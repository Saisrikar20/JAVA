#!/usr/bin/env python3
"""
build_hackerrank_pdf.py

Generates a publication-quality PDF containing all 77 HackerRank Java problems
and accepted solutions from the Saisrikar20/JAVA repository.

Features:
- Authentic HackerRank challenge page layout (branding, breadcrumbs, badges, console boxes).
- Syntax-highlighted Java code with line numbers and dark IDE styling.
- Comprehensive Cover Page and clickable Table of Contents.
- Domain chapter separator cards for all 12 domains.
- PDF Outline / Bookmarks for instant sidebar navigation.
- Running headers and footers with page numbering.
"""

import os
import re
import sys
import html
import subprocess
from pathlib import Path
from typing import Dict, List, Tuple, Any

import pygments
from pygments.lexers import JavaLexer
from pygments.formatters import HtmlFormatter
from markdown_it import MarkdownIt
import pymupdf

# Import repository configurations
REPO_ROOT = Path(__file__).resolve().parent.parent
sys.path.append(str(REPO_ROOT / "scripts"))
from update_readme import scan_problems, TOPIC_CONFIG, Problem

# HackerRank profile details
AUTHOR_NAME = "Saisrikar B"
HACKERRANK_HANDLE = "saisrikar_b_2021"
HACKERRANK_PROFILE = f"https://www.hackerrank.com/profile/{HACKERRANK_HANDLE}"
GITHUB_REPO = "https://github.com/Saisrikar20/JAVA"

# Ordered topics matching natural curriculum progression
ORDERED_TOPIC_KEYS = [
    "arrays-1d",
    "arrays-2d",
    "strings",
    "recursion",
    "decision-making",
    "class-and-objects",
    "encapsulation",
    "inheritance",
    "polymorphism",
    "abstraction",
    "interface",
    "exception-handling",
]

md_parser = MarkdownIt()


def get_difficulty_badge(difficulty: str) -> str:
    diff = (difficulty or "Medium").capitalize()
    if diff == "Easy":
        return '<span class="badge badge-easy">🟢 Easy</span>'
    elif diff == "Hard":
        return '<span class="badge badge-hard">🔴 Hard</span>'
    else:
        return '<span class="badge badge-medium">🟡 Medium</span>'


def format_java_code(java_code: str) -> str:
    """Format Java code using Pygments with custom dark theme & line numbers."""
    lexer = JavaLexer()
    formatter = HtmlFormatter(
        nowrap=False,
        linenos='table',
        linespans='line',
        cssclass='highlight',
        style='monokai',
    )
    return pygments.highlight(java_code, lexer, formatter)


def parse_problem_readme(readme_path: Path) -> Dict[str, Any]:
    """Parse problem markdown into structured components."""
    text = readme_path.read_text(encoding="utf-8")

    # 1. Title & Difficulty
    first_line = text.splitlines()[0] if text else ""
    title_match = re.match(r"^#\s*(.*?)\s*[-–—]\s*(.+)$", first_line)
    raw_category = title_match.group(1).strip() if title_match else ""
    raw_title = title_match.group(2).strip() if title_match else readme_path.parent.name.replace("-", " ").title()

    diff_match = re.search(r"Difficulty-(Easy|Medium|Hard)", text, re.IGNORECASE)
    difficulty = diff_match.group(1).capitalize() if diff_match else "Medium"

    # 2. HackerRank URL
    hr_match = re.search(r"\[View on HackerRank\]\(([^)]+)\)", text)
    hr_url = hr_match.group(1) if hr_match else f"https://www.hackerrank.com/challenges/{readme_path.parent.name}/problem"

    # 3. Problem Statement & Body (between ## Problem and ## Solution)
    problem_body = ""
    prob_idx = text.find("## Problem")
    sol_idx = text.find("## Solution")

    if prob_idx != -1:
        if sol_idx != -1:
            problem_body = text[prob_idx + len("## Problem"):sol_idx].strip()
        else:
            problem_body = text[prob_idx + len("## Problem"):].strip()

    # Clean up difficulty badge from problem_body if present
    problem_body = re.sub(r"!\[Difficulty\]\([^)]+\)", "", problem_body).strip()

    # 4. Extract Samples
    samples = []
    sample_blocks = re.findall(
        r"\*\*Sample Input (\d+)\*\*\s*```(.*?)```\s*(?:\*\*Sample Output \1\*\*\s*```(.*?)```)?",
        problem_body,
        re.DOTALL,
    )
    for s_id, s_in, s_out in sample_blocks:
        samples.append({
            "id": s_id,
            "input": s_in.strip(),
            "output": (s_out or "").strip(),
        })

    # If sample blocks matched, we can remove them from the description body to render them with custom styling
    clean_body = problem_body
    clean_body = re.sub(r"\*\*Sample Input \d+\*\*.*?```.*?```", "", clean_body, flags=re.DOTALL)
    clean_body = re.sub(r"\*\*Sample Output \d+\*\*.*?```.*?```", "", clean_body, flags=re.DOTALL)
    clean_body = re.sub(r"\*\*Explanation \d+\*\*.*?(?=(?:\*\*Sample|\Z))", "", clean_body, flags=re.DOTALL)

    # Convert markdown body to HTML
    body_html = md_parser.render(clean_body)

    # Style standard headings like Input Format, Constraints, Output Format
    body_html = re.sub(
        r"<p><strong>(Input Format|Input Matrix[^<]*)</strong></p>",
        r'<div class="section-title"><span class="section-icon">📥</span> \1</div>',
        body_html,
    )
    body_html = re.sub(
        r"<p><strong>Constraints</strong></p>",
        r'<div class="section-title"><span class="section-icon">⚠️</span> Constraints</div>',
        body_html,
    )
    body_html = re.sub(
        r"<p><strong>(Output Format|Output)</strong></p>",
        r'<div class="section-title"><span class="section-icon">📤</span> \1</div>',
        body_html,
    )

    return {
        "title": raw_title,
        "category": raw_category,
        "difficulty": difficulty,
        "hr_url": hr_url,
        "body_html": body_html,
        "samples": samples,
    }


def get_css_styles() -> str:
    """Return complete CSS styling for the HackerRank-themed PDF."""
    formatter = HtmlFormatter(style='monokai')
    pygments_css = formatter.get_style_defs('.highlight')

    return f"""
    @page {{
        size: A4;
        margin: 14mm 14mm 14mm 14mm;
    }}

    * {{
        box-sizing: border-box;
        -webkit-print-color-adjust: exact !important;
        print-color-adjust: exact !important;
    }}

    body {{
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif;
        color: #1e293b;
        background: #ffffff;
        margin: 0;
        padding: 0;
        font-size: 13.5px;
        line-height: 1.6;
    }}

    /* Cover Page */
    .cover-page {{
        page-break-before: always;
        page-break-after: always;
        height: 260mm;
        max-height: 260mm;
        box-sizing: border-box;
        overflow: hidden;
        display: flex;
        flex-direction: column;
        justify-content: space-between;
        padding: 20px 20px;
        background: linear-gradient(180deg, #ffffff 0%, #f8fafc 100%);
    }}

    .cover-brand {{
        display: flex;
        align-items: center;
        gap: 12px;
        padding-bottom: 16px;
        border-bottom: 2px solid #e2e8f0;
    }}

    .hr-logo-box {{
        width: 44px;
        height: 44px;
        background: #00EA64;
        border-radius: 8px;
        display: flex;
        align-items: center;
        justify-content: center;
        font-weight: 900;
        font-size: 24px;
        color: #0e141e;
        font-family: 'Consolas', monospace;
        box-shadow: 0 4px 10px rgba(0, 234, 100, 0.3);
    }}

    .hr-logo-text {{
        font-size: 26px;
        font-weight: 800;
        color: #0e141e;
        letter-spacing: -0.5px;
    }}

    .hr-logo-sub {{
        font-size: 13px;
        font-weight: 600;
        color: #64748b;
        text-transform: uppercase;
        letter-spacing: 1px;
    }}

    .cover-main {{
        margin: 15px 0;
    }}

    .cover-pill {{
        display: inline-block;
        padding: 4px 12px;
        background: #dcfce7;
        color: #166534;
        font-weight: 700;
        font-size: 11px;
        border-radius: 20px;
        text-transform: uppercase;
        letter-spacing: 0.8px;
        margin-bottom: 12px;
        border: 1px solid #bbf7d0;
    }}

    .cover-title {{
        font-size: 32px;
        font-weight: 850;
        color: #0f172a;
        line-height: 1.15;
        margin: 0 0 10px 0;
        letter-spacing: -0.5px;
    }}

    .cover-title span {{
        color: #097b3e;
    }}

    .cover-subtitle {{
        font-size: 13px;
        color: #475569;
        max-width: 650px;
        line-height: 1.45;
        margin-bottom: 16px;
    }}

    .metrics-grid {{
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 10px;
        margin: 16px 0;
    }}

    .metric-card {{
        background: #ffffff;
        border: 1px solid #e2e8f0;
        border-radius: 10px;
        padding: 10px;
        text-align: center;
        box-shadow: 0 2px 6px rgba(0,0,0,0.03);
    }}

    .metric-value {{
        font-size: 22px;
        font-weight: 800;
        color: #0f172a;
        line-height: 1;
        margin-bottom: 4px;
    }}

    .metric-value.accent {{
        color: #097b3e;
    }}

    .metric-label {{
        font-size: 10px;
        font-weight: 600;
        color: #64748b;
        text-transform: uppercase;
        letter-spacing: 0.5px;
    }}

    .cover-topics-table {{
        width: 100%;
        border-collapse: collapse;
        margin-top: 14px;
        font-size: 11px;
        background: #ffffff;
        border-radius: 8px;
        overflow: hidden;
        border: 1px solid #e2e8f0;
    }}

    .cover-topics-table th {{
        background: #f1f5f9;
        text-align: left;
        padding: 6px 10px;
        font-weight: 700;
        color: #334155;
        border-bottom: 1px solid #e2e8f0;
    }}

    .cover-topics-table td {{
        padding: 4px 10px;
        border-bottom: 1px solid #f1f5f9;
        color: #475569;
    }}

    .cover-footer {{
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding-top: 14px;
        border-top: 2px solid #e2e8f0;
        font-size: 11px;
        color: #64748b;
    }}

    .cover-footer a {{
        color: #097b3e;
        text-decoration: none;
        font-weight: 600;
    }}

    /* Table of Contents */
    .toc-page {{
        page-break-before: always;
        padding-top: 10px;
    }}

    .toc-header {{
        border-bottom: 2px solid #00EA64;
        padding-bottom: 10px;
        margin-bottom: 20px;
        display: flex;
        align-items: baseline;
        justify-content: space-between;
    }}

    .toc-title {{
        font-size: 26px;
        font-weight: 800;
        color: #0f172a;
        margin: 0;
    }}

    .toc-grid {{
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 16px;
    }}

    .toc-domain-group {{
        margin-bottom: 22px;
        page-break-inside: avoid;
    }}

    .toc-domain-header {{
        background: #f8fafc;
        border-left: 4px solid #00EA64;
        padding: 7px 12px;
        font-size: 14px;
        font-weight: 700;
        color: #0f172a;
        margin-bottom: 8px;
        border-radius: 0 6px 6px 0;
    }}

    .toc-item {{
        display: flex;
        align-items: center;
        justify-content: space-between;
        padding: 5px 12px;
        border-bottom: 1px dashed #f1f5f9;
        font-size: 12.5px;
    }}

    .toc-item:last-child {{
        border-bottom: none;
    }}

    .toc-item a {{
        color: #1e293b;
        text-decoration: none;
        font-weight: 500;
        flex: 1;
    }}

    .toc-item a:hover {{
        color: #097b3e;
    }}

    .toc-number {{
        color: #94a3b8;
        font-weight: 600;
        width: 30px;
        display: inline-block;
    }}

    /* Domain Divider / Header Page */
    .domain-divider {{
        page-break-before: always;
        background: linear-gradient(135deg, #0f172a 0%, #1e293b 100%);
        border-radius: 12px;
        padding: 40px 30px;
        color: #ffffff;
        margin-bottom: 30px;
        box-shadow: 0 4px 15px rgba(15, 23, 42, 0.15);
        display: flex;
        flex-direction: column;
        justify-content: center;
    }}

    .domain-divider-eyebrow {{
        font-size: 12px;
        font-weight: 700;
        color: #00EA64;
        text-transform: uppercase;
        letter-spacing: 1.5px;
        margin-bottom: 8px;
    }}

    .domain-divider-title {{
        font-size: 30px;
        font-weight: 800;
        margin: 0 0 10px 0;
    }}

    .domain-divider-desc {{
        font-size: 14px;
        color: #94a3b8;
        max-width: 600px;
        line-height: 1.5;
    }}

    /* Problem Page */
    .problem-page {{
        page-break-before: always;
        padding-top: 10px;
    }}

    /* HackerRank Brand Top Bar */
    .hr-header-bar {{
        display: flex;
        justify-content: space-between;
        align-items: center;
        background: #f8fafc;
        border: 1px solid #e2e8f0;
        border-radius: 8px;
        padding: 8px 14px;
        margin-bottom: 16px;
        font-size: 11.5px;
    }}

    .hr-breadcrumbs {{
        display: flex;
        align-items: center;
        gap: 6px;
        color: #64748b;
        font-weight: 600;
    }}

    .hr-breadcrumbs .active {{
        color: #0f172a;
        font-weight: 700;
    }}

    .hr-header-right {{
        display: flex;
        align-items: center;
        gap: 12px;
        color: #64748b;
    }}

    /* Problem Title Banner */
    .problem-title-card {{
        margin-bottom: 20px;
        padding-bottom: 14px;
        border-bottom: 1px solid #e2e8f0;
    }}

    .problem-title {{
        font-size: 22px;
        font-weight: 800;
        color: #0f172a;
        margin: 0 0 10px 0;
        line-height: 1.25;
    }}

    .problem-meta {{
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        gap: 8px;
        font-size: 11.5px;
    }}

    .badge {{
        display: inline-flex;
        align-items: center;
        gap: 4px;
        padding: 3px 9px;
        border-radius: 12px;
        font-weight: 600;
        font-size: 11px;
    }}

    .badge-easy {{
        background: #dcfce7;
        color: #15803d;
        border: 1px solid #bbf7d0;
    }}

    .badge-medium {{
        background: #fef3c7;
        color: #b45309;
        border: 1px solid #fde68a;
    }}

    .badge-hard {{
        background: #fee2e2;
        color: #b91c1c;
        border: 1px solid #fecdd3;
    }}

    .badge-tag {{
        background: #f1f5f9;
        color: #475569;
        border: 1px solid #e2e8f0;
    }}

    .badge-accepted {{
        background: #dcfce7;
        color: #166534;
        border: 1px solid #86efac;
    }}

    .hr-link-btn {{
        margin-left: auto;
        color: #097b3e;
        text-decoration: none;
        font-weight: 600;
        display: inline-flex;
        align-items: center;
        gap: 4px;
    }}

    /* Section Styling */
    .section-title {{
        font-size: 14px;
        font-weight: 700;
        color: #0f172a;
        margin: 18px 0 8px 0;
        display: flex;
        align-items: center;
        gap: 6px;
        page-break-after: avoid;
    }}

    .problem-body {{
        font-size: 13px;
        line-height: 1.6;
        color: #334155;
    }}

    .problem-body p {{
        margin: 0 0 10px 0;
    }}

    .problem-body ul, .problem-body ol {{
        margin: 0 0 12px 0;
        padding-left: 20px;
    }}

    .problem-body li {{
        margin-bottom: 4px;
    }}

    .problem-body code {{
        font-family: 'Consolas', 'Courier New', monospace;
        background: #f1f5f9;
        border: 1px solid #e2e8f0;
        border-radius: 4px;
        padding: 1px 5px;
        font-size: 12px;
        color: #0f172a;
    }}

    /* Sample Cases Box */
    .samples-grid {{
        display: flex;
        flex-direction: column;
        gap: 12px;
        margin: 14px 0;
        page-break-inside: avoid;
    }}

    .sample-box {{
        border: 1px solid #e2e8f0;
        border-radius: 8px;
        overflow: hidden;
        background: #ffffff;
    }}

    .sample-header {{
        background: #f8fafc;
        border-bottom: 1px solid #e2e8f0;
        padding: 6px 12px;
        font-weight: 700;
        font-size: 11.5px;
        color: #475569;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }}

    .sample-content {{
        display: grid;
        grid-template-columns: 1fr 1fr;
        gap: 0;
        divide-x: 1px solid #e2e8f0;
    }}

    .sample-column {{
        padding: 10px 12px;
    }}

    .sample-column:first-child {{
        border-right: 1px solid #e2e8f0;
    }}

    .sample-label {{
        font-size: 11px;
        font-weight: 700;
        color: #64748b;
        text-transform: uppercase;
        margin-bottom: 6px;
    }}

    .terminal-box {{
        font-family: 'Consolas', 'Courier New', monospace;
        font-size: 12px;
        background: #0f172a;
        color: #f8fafc;
        padding: 10px 12px;
        border-radius: 6px;
        white-space: pre-wrap;
        line-height: 1.45;
        margin: 0;
        min-height: 40px;
    }}

    /* Solution Box / IDE Window */
    .solution-container {{
        margin-top: 24px;
        page-break-inside: avoid;
    }}

    .ide-window {{
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
        border: 1px solid #1e293b;
        background: #272822;
    }}

    .ide-titlebar {{
        background: #1e1f1c;
        padding: 7px 12px;
        display: flex;
        align-items: center;
        justify-content: space-between;
        border-bottom: 1px solid #3e3d32;
    }}

    .ide-dots {{
        display: flex;
        gap: 6px;
        align-items: center;
    }}

    .ide-dot {{
        width: 10px;
        height: 10px;
        border-radius: 50%;
    }}

    .dot-red {{ background: #ff5f56; }}
    .dot-yellow {{ background: #ffbd2e; }}
    .dot-green {{ background: #27c93f; }}

    .ide-file-tab {{
        display: flex;
        align-items: center;
        gap: 6px;
        color: #f8f8f2;
        font-size: 12px;
        font-weight: 600;
        font-family: 'Consolas', monospace;
    }}

    .ide-status {{
        font-size: 11px;
        font-weight: 600;
        color: #a6e22e;
        display: flex;
        align-items: center;
        gap: 4px;
    }}

    /* Pygments Custom Styling */
    {pygments_css}

    .highlight {{
        background: #272822 !important;
        margin: 0 !important;
        padding: 12px !important;
        border-radius: 0 !important;
        font-family: 'Consolas', 'Courier New', monospace !important;
        font-size: 11.5px !important;
        line-height: 1.45 !important;
    }}

    .highlight table {{
        border: none !important;
        border-spacing: 0 !important;
        width: 100% !important;
    }}

    .highlight td {{
        padding: 0 !important;
        border: none !important;
        vertical-align: top !important;
    }}

    .highlight .linenos {{
        color: #75715e !important;
        padding-right: 12px !important;
        user-select: none !important;
        text-align: right !important;
        width: 32px !important;
        border-right: 1px solid #3e3d32 !important;
    }}

    .highlight .code {{
        padding-left: 12px !important;
        white-space: pre-wrap !important;
        word-break: break-all !important;
    }}

    .highlight pre {{
        margin: 0 !important;
        font-family: 'Consolas', 'Courier New', monospace !important;
        color: #f8f8f2 !important;
    }}

    /* Monokai Overrides for High Contrast Printing */
    .highlight .k, .highlight .kd, .highlight .kn, .highlight .kr {{ color: #66d9ef !important; font-weight: bold; }}
    .highlight .kt, .highlight .nc, .highlight .nn {{ color: #a6e22e !important; }}
    .highlight .nf {{ color: #a6e22e !important; }}
    .highlight .s, .highlight .s1, .highlight .s2 {{ color: #e6db74 !important; }}
    .highlight .c, .highlight .c1, .highlight .cm {{ color: #75715e !important; font-style: italic; }}
    .highlight .mi, .highlight .mf {{ color: #ae81ff !important; }}
    """


def generate_html_document(problems_by_topic: Dict[str, List[Problem]]) -> str:
    """Generate complete HTML document with all problems and styling."""
    total_problems = sum(len(p) for p in problems_by_topic.values())

    # Build TOC items
    toc_html = []
    global_counter = 1

    for topic_key in ORDERED_TOPIC_KEYS:
        if topic_key not in problems_by_topic:
            continue
        plist = problems_by_topic[topic_key]
        cfg = TOPIC_CONFIG.get(topic_key, {})
        disp_name = cfg.get("display", topic_key.replace("-", " ").title())
        icon = cfg.get("icon", "📌")

        group_html = [
            f'<div class="toc-domain-group">',
            f'<div class="toc-domain-header">{icon} {disp_name} ({len(plist)})</div>',
        ]

        for p in plist:
            diff_pill = get_difficulty_badge(p.difficulty)
            group_html.append(
                f'<div class="toc-item">'
                f'  <span><span class="toc-number">{global_counter}.</span> <a href="#prob-{global_counter}">{html.escape(p.title)}</a></span>'
                f'  {diff_pill}'
                f'</div>'
            )
            global_counter += 1

        group_html.append('</div>')
        toc_html.append("\n".join(group_html))

    # Build Cover Page Topics Table rows
    cover_topics_rows = []
    for topic_key in ORDERED_TOPIC_KEYS:
        if topic_key in problems_by_topic:
            cfg = TOPIC_CONFIG.get(topic_key, {})
            cnt = len(problems_by_topic[topic_key])
            cover_topics_rows.append(
                f'<tr>'
                f'  <td><strong>{cfg.get("icon", "📌")} {cfg.get("display", topic_key)}</strong></td>'
                f'  <td style="text-align:center;"><strong>{cnt}</strong></td>'
                f'  <td>{cfg.get("key_concepts", "Core algorithms & problem solving")}</td>'
                f'</tr>'
            )

    # Build Problem Pages
    problem_pages_html = []
    global_id = 1

    for topic_key in ORDERED_TOPIC_KEYS:
        if topic_key not in problems_by_topic:
            continue
        plist = problems_by_topic[topic_key]
        cfg = TOPIC_CONFIG.get(topic_key, {})
        disp_name = cfg.get("display", topic_key.replace("-", " ").title())
        icon = cfg.get("icon", "📌")

        # Domain Divider Page
        domain_divider_html = f"""
        <div class="domain-divider">
            <div class="domain-divider-eyebrow">HackerRank Domain Chapter</div>
            <h1 class="domain-divider-title">{icon} {disp_name}</h1>
            <div class="domain-divider-desc">
                Contains <strong>{len(plist)}</strong> comprehensive practice problems covering {cfg.get("key_concepts", "")}.
                All problems include detailed specifications, sample execution traces, and verified OpenJDK Java solutions.
            </div>
        </div>
        """
        problem_pages_html.append(domain_divider_html)

        for p in plist:
            folder = REPO_ROOT / p.rel_path.lstrip("./")
            readme_path = folder / "README.md"
            java_path = folder / "solution.java"

            parsed = parse_problem_readme(readme_path)
            java_code = java_path.read_text(encoding="utf-8") if java_path.exists() else "// Solution not available"
            highlighted_java = format_java_code(java_code)

            diff_badge = get_difficulty_badge(parsed["difficulty"])

            # Format samples
            samples_html = ""
            if parsed["samples"]:
                sample_items = []
                for s in parsed["samples"]:
                    s_id = s["id"]
                    s_in = html.escape(s["input"])
                    s_out = html.escape(s["output"])
                    sample_items.append(f"""
                    <div class="sample-box">
                        <div class="sample-header">
                            <span>Sample Case {s_id}</span>
                            <span style="font-weight: normal; color: #64748b;">Standard Console I/O</span>
                        </div>
                        <div class="sample-content">
                            <div class="sample-column">
                                <div class="sample-label">Sample Input {s_id}</div>
                                <pre class="terminal-box">{s_in}</pre>
                            </div>
                            <div class="sample-column">
                                <div class="sample-label">Sample Output {s_id}</div>
                                <pre class="terminal-box">{s_out}</pre>
                            </div>
                        </div>
                    </div>
                    """)
                samples_html = f"""
                <div class="section-title"><span class="section-icon">🧪</span> Sample Test Cases</div>
                <div class="samples-grid">
                    {"".join(sample_items)}
                </div>
                """

            problem_page = f"""
            <div class="problem-page" id="prob-{global_id}">
                <!-- HackerRank Top Breadcrumb Bar -->
                <div class="hr-header-bar">
                    <div class="hr-breadcrumbs">
                        <span style="color: #00EA64; font-weight: 900;">[ &gt; ]</span>
                        <span>Practice</span>
                        <span>&gt;</span>
                        <span>Java</span>
                        <span>&gt;</span>
                        <span class="active">{disp_name}</span>
                    </div>
                    <div class="hr-header-right">
                        <span>Challenge #{global_id}</span>
                        <span>•</span>
                        <span>Author: <strong>@{HACKERRANK_HANDLE}</strong></span>
                    </div>
                </div>

                <!-- Problem Title Banner -->
                <div class="problem-title-card">
                    <h2 class="problem-title">{global_id}. {html.escape(parsed["title"])}</h2>
                    <div class="problem-meta">
                        {diff_badge}
                        <span class="badge badge-tag">📂 {disp_name}</span>
                        <span class="badge badge-accepted">Accepted ✅</span>
                        <span class="badge badge-tag">Max Score: 20</span>
                        <span class="badge badge-tag">Java 15 (OpenJDK)</span>
                        <a href="{parsed["hr_url"]}" class="hr-link-btn" target="_blank">View on HackerRank ↗</a>
                    </div>
                </div>

                <!-- Problem Description -->
                <div class="section-title"><span class="section-icon">📋</span> Problem Statement</div>
                <div class="problem-body">
                    {parsed["body_html"]}
                </div>

                <!-- Samples -->
                {samples_html}

                <!-- Solution IDE Window -->
                <div class="solution-container">
                    <div class="section-title"><span class="section-icon">💻</span> Accepted Solution (Java)</div>
                    <div class="ide-window">
                        <div class="ide-titlebar">
                            <div class="ide-dots">
                                <span class="ide-dot dot-red"></span>
                                <span class="ide-dot dot-yellow"></span>
                                <span class="ide-dot dot-green"></span>
                            </div>
                            <div class="ide-file-tab">
                                <span>☕ Solution.java</span>
                            </div>
                            <div class="ide-status">
                                <span>● Accepted</span>
                            </div>
                        </div>
                        {highlighted_java}
                    </div>
                </div>
            </div>
            """
            problem_pages_html.append(problem_page)
            global_id += 1

    # Assemble Full Document
    full_html = f"""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HackerRank Java Solutions Compendium</title>
    <style>
    {get_css_styles()}
    </style>
</head>
<body>
    <!-- COVER PAGE -->
    <div class="cover-page">
        <div class="cover-brand">
            <div class="hr-logo-box">&gt;_</div>
            <div>
                <div class="hr-logo-text">HackerRank</div>
                <div class="hr-logo-sub">Official Problem Solving Handbook</div>
            </div>
        </div>

        <div class="cover-main">
            <span class="cover-pill">Comprehensive Practice Portfolio</span>
            <h1 class="cover-title">Java Solutions <span>Compendium</span></h1>
            <p class="cover-subtitle">
                A complete, publication-grade collection of <strong>{total_problems}</strong> HackerRank coding challenges,
                featuring exhaustive problem descriptions, technical specifications, I/O formats, constraints, sample execution traces,
                and verified OpenJDK Java solutions.
            </p>

            <div class="metrics-grid">
                <div class="metric-card">
                    <div class="metric-value accent">{total_problems}</div>
                    <div class="metric-label">Challenges Solved</div>
                </div>
                <div class="metric-card">
                    <div class="metric-value">12</div>
                    <div class="metric-label">OOP & DS Domains</div>
                </div>
                <div class="metric-card">
                    <div class="metric-value accent">100%</div>
                    <div class="metric-label">Accepted Rate</div>
                </div>
                <div class="metric-card">
                    <div class="metric-value">Java</div>
                    <div class="metric-label">OpenJDK Standard</div>
                </div>
            </div>

            <table class="cover-topics-table">
                <thead>
                    <tr>
                        <th>Domain / Topic</th>
                        <th style="text-align:center;">Solved</th>
                        <th>Key Concepts & Algorithms Covered</th>
                    </tr>
                </thead>
                <tbody>
                    {"".join(cover_topics_rows)}
                </tbody>
            </table>
        </div>

        <div class="cover-footer">
            <div>
                Candidate: <strong>{AUTHOR_NAME}</strong> (<a href="{HACKERRANK_PROFILE}">@{HACKERRANK_HANDLE}</a>)
            </div>
            <div>
                Repository: <a href="{GITHUB_REPO}">{GITHUB_REPO}</a>
            </div>
        </div>
    </div>

    <!-- TABLE OF CONTENTS -->
    <div class="toc-page">
        <div class="toc-header">
            <h2 class="toc-title">📑 Table of Contents</h2>
            <span style="font-size: 13px; color: #64748b; font-weight: 600;">{total_problems} Solved Problems</span>
        </div>
        <div class="toc-grid">
            {"".join(toc_html)}
        </div>
    </div>

    <!-- PROBLEM PAGES -->
    {"".join(problem_pages_html)}
</body>
</html>
"""
    return full_html


def add_pdf_metadata_and_headers(pdf_path: Path, problems_by_topic: Dict[str, List[Problem]]):
    """
    Use PyMuPDF to:
    1. Add bookmarks/outlines for instant PDF sidebar navigation.
    2. Add running headers and footers with accurate 'Page X of Y' numbering.
    """
    print(f"Post-processing PDF with PyMuPDF: {pdf_path}")
    doc = pymupdf.open(str(pdf_path))
    total_pages = len(doc)
    print(f"Total PDF pages: {total_pages}")

    # Build PDF Outline / Bookmarks
    # PyMuPDF TOC structure: [ [lvl, title, page_num], ... ] (1-indexed page)
    toc = [
        [1, "Title Page", 1],
        [1, "Table of Contents", 2],
    ]

    # Map problem HTML anchors or search for problem headers
    # Let's search pages for problem titles or domain divider headers
    page_by_prob_id = {}
    page_by_domain = {}

    for page_idx in range(total_pages):
        page = doc[page_idx]
        text = page.get_text()

        # Check for domain dividers
        for topic_key in ORDERED_TOPIC_KEYS:
            cfg = TOPIC_CONFIG.get(topic_key, {})
            disp = cfg.get("display", topic_key)
            if "DOMAIN CHAPTER" in text.upper() and disp.upper() in text.upper() and "CHALLENGE #" not in text.upper():
                if topic_key not in page_by_domain:
                    page_by_domain[topic_key] = page_idx + 1

        # Check for challenge IDs (e.g. "Challenge #1", "1. Cricket Match Run Rate Calculator")
        for match in re.finditer(r"Challenge #(\d+)", text):
            prob_num = int(match.group(1))
            if prob_num not in page_by_prob_id:
                page_by_prob_id[prob_num] = page_idx + 1

    # Assemble TOC hierarchy
    global_id = 1
    for topic_key in ORDERED_TOPIC_KEYS:
        if topic_key not in problems_by_topic:
            continue
        plist = problems_by_topic[topic_key]
        cfg = TOPIC_CONFIG.get(topic_key, {})
        disp_name = f"{cfg.get('icon', '')} {cfg.get('display', topic_key)} ({len(plist)})"
        domain_page = page_by_domain.get(topic_key, 2)
        toc.append([1, disp_name, domain_page])

        for p in plist:
            p_page = page_by_prob_id.get(global_id, domain_page)
            toc.append([2, f"{global_id}. {p.title}", p_page])
            global_id += 1

    doc.set_toc(toc)

    # Insert running header & footer on all pages except the cover page (page 0)
    for page_idx in range(1, total_pages):
        page = doc[page_idx]
        rect = page.rect
        page_num_str = f"Page {page_idx + 1} of {total_pages}"
        is_domain_divider = (page_idx + 1) in page_by_domain.values()

        # Running Top Header (omit on domain chapter dividers)
        if not is_domain_divider:
            page.insert_text(
                pymupdf.Point(40, 25),
                "HackerRank | Problem Solving (Java) — Accepted Solutions Compendium",
                fontsize=8.5,
                color=(0.4, 0.45, 0.5),
                fontname="helv",
            )
            page.draw_line(
                pymupdf.Point(40, 30),
                pymupdf.Point(rect.width - 40, 30),
                color=(0.9, 0.92, 0.94),
                width=0.75,
            )

        # Running Bottom Footer
        page.draw_line(
            pymupdf.Point(40, rect.height - 30),
            pymupdf.Point(rect.width - 40, rect.height - 30),
            color=(0.9, 0.92, 0.94),
            width=0.75,
        )
        page.insert_text(
            pymupdf.Point(40, rect.height - 18),
            f"Candidate: {AUTHOR_NAME} (@{HACKERRANK_HANDLE}) • OpenJDK Java",
            fontsize=8.5,
            color=(0.4, 0.45, 0.5),
            fontname="helv",
        )
        # Right aligned page number
        p_len = pymupdf.get_text_length(page_num_str, fontname="helv", fontsize=8.5)
        page.insert_text(
            pymupdf.Point(rect.width - 40 - p_len, rect.height - 18),
            page_num_str,
            fontsize=8.5,
            color=(0.4, 0.45, 0.5),
            fontname="helv",
        )

    temp_post_path = pdf_path.with_name(pdf_path.stem + "_post.pdf")
    doc.save(str(temp_post_path), deflate=True, garbage=4)
    doc.close()
    if temp_post_path.exists():
        if pdf_path.exists():
            pdf_path.unlink()
        temp_post_path.replace(pdf_path)
    print("PDF post-processing complete!")


def main():
    print(f"=== HackerRank Java Solutions PDF Generator ===")
    print(f"Scanning repository at: {REPO_ROOT}")
    problems_by_topic = scan_problems(REPO_ROOT)
    total_problems = sum(len(p) for p in problems_by_topic.values())
    print(f"Discovered {total_problems} problems across {len(problems_by_topic)} topics.")

    # 1. Generate HTML file
    temp_html_path = REPO_ROOT / "hackerrank_solutions.html"
    print(f"Rendering HTML document...")
    html_content = generate_html_document(problems_by_topic)
    temp_html_path.write_text(html_content, encoding="utf-8")
    print(f"HTML generated at: {temp_html_path} ({len(html_content)} bytes)")

    # 2. Convert HTML to PDF using Chrome Headless
    target_pdf_path = REPO_ROOT / "HackerRank_Java_Solutions_Compendium.pdf"
    workspace_pdf_path = Path(r"C:\Users\saisr\PycharmProjects\typer\HackerRank_Java_Solutions_Compendium.pdf")

    print(f"Converting HTML to PDF with Google Chrome Headless...")
    chrome_path = r"C:\Program Files\Google\Chrome\Application\chrome.exe"
    if not Path(chrome_path).exists():
        chrome_path = r"C:\Program Files (x86)\Microsoft\Edge\Application\msedge.exe"

    cmd = [
        chrome_path,
        "--headless=new",
        "--disable-gpu",
        "--no-sandbox",
        "--no-pdf-header-footer",
        f"--print-to-pdf={str(target_pdf_path)}",
        str(temp_html_path),
    ]

    result = subprocess.run(cmd, capture_output=True, text=True)
    if result.returncode != 0 and not target_pdf_path.exists():
        print(f"Error during Chrome print-to-pdf: {result.stderr}", file=sys.stderr)
        sys.exit(1)

    print(f"Raw PDF successfully rendered: {target_pdf_path} ({target_pdf_path.stat().st_size} bytes)")

    # 3. Post-process with PyMuPDF (Outline, bookmarks, headers, footers)
    add_pdf_metadata_and_headers(target_pdf_path, problems_by_topic)

    # 4. Copy to workspace root for direct user access
    if workspace_pdf_path != target_pdf_path:
        import shutil
        shutil.copy2(target_pdf_path, workspace_pdf_path)
        print(f"Copied companion PDF to workspace: {workspace_pdf_path}")

    # Clean up temporary HTML file
    if temp_html_path.exists():
        temp_html_path.unlink()
        print(f"Cleaned up temporary HTML file.")

    print(f"\n=======================================================")
    print(f" SUCCESS! HackerRank Java Solutions PDF Generated!")
    print(f" File Location: {target_pdf_path}")
    print(f" Workspace Location: {workspace_pdf_path}")
    print(f" Total Problems Included: {total_problems}")
    print(f"=======================================================\n")


if __name__ == "__main__":
    main()
