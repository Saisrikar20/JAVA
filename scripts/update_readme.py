#!/usr/bin/env python3
"""
update_readme.py

Automatically scans the repository for HackerRank Java solutions,
extracts problem metadata, computes statistics, updates README.md with
clean collapsible sections (matching the DBMS repository design),
and maintains a comprehensive SOLUTIONS.md catalog.
"""

import argparse
import os
import re
import sys
from pathlib import Path
from typing import Dict, List, Tuple

# Ensure UTF-8 output across environments
if hasattr(sys.stdout, "reconfigure"):
    try:
        sys.stdout.reconfigure(encoding="utf-8")
    except Exception:
        pass
if hasattr(sys.stderr, "reconfigure"):
    try:
        sys.stderr.reconfigure(encoding="utf-8")
    except Exception:
        pass

REPO_NAME = "JAVA"
GITHUB_USER = "Saisrikar20"
HACKERRANK_USERNAME = "saisrikar_b_2021"
HACKERRANK_PROFILE_URL = f"https://www.hackerrank.com/profile/{HACKERRANK_USERNAME}"
GITHUB_REPO_URL = f"https://github.com/{GITHUB_USER}/{REPO_NAME}"

TOPIC_CONFIG: Dict[str, Dict[str, str]] = {
    "arrays-1d": {
        "display": "Arrays (1D)",
        "icon": "🔢",
        "key_concepts": "Median finding, filtering",
    },
    "arrays-2d": {
        "display": "Arrays (2D)",
        "icon": "🔢",
        "key_concepts": "Matrix traversal, rotation, diagonal sums, snake patterns",
    },
    "class-and-objects": {
        "display": "Classes & Objects",
        "icon": "🏗️",
        "key_concepts": "Encapsulation, state management, domain modeling",
    },
    "inheritance": {
        "display": "Inheritance",
        "icon": "🧬",
        "key_concepts": "Class hierarchies, method overriding, multilevel inheritance",
    },
    "recursion": {
        "display": "Recursion",
        "icon": "🔁",
        "key_concepts": "Divide & conquer, bit counting, validation",
    },
    "strings": {
        "display": "Strings",
        "icon": "🔤",
        "key_concepts": "Parsing, character frequency, word reversal",
    },
}

BADGES_START = "<!-- BADGES:START -->"
BADGES_END = "<!-- BADGES:END -->"
STATS_START = "<!-- STATS:START -->"
STATS_END = "<!-- STATS:END -->"
PROBLEMS_START = "<!-- PROBLEMS_TABLE:START -->"
PROBLEMS_END = "<!-- PROBLEMS_TABLE:END -->"


class Problem:
    def __init__(self, topic_key: str, folder_name: str, title: str, rel_path: str, java_file_rel: str, concepts: str, difficulty: str = "Medium"):
        self.topic_key = topic_key
        self.folder_name = folder_name
        self.title = title
        self.rel_path = rel_path.replace("\\", "/")
        self.java_file_rel = java_file_rel.replace("\\", "/")
        self.concepts = concepts
        self.difficulty = difficulty


def detect_problem_concepts(folder_name: str, topic_key: str) -> str:
    """Generates specific topic and algorithm tags for a problem."""
    tags = []
    f = folder_name.lower()
    if "median" in f:
        tags.append("`Median Finding`")
    if "unsold" in f:
        tags.append("`Element Filtering`")
    if "defect" in f:
        tags.append("`Defect Level Analysis`")
    if "rotation" in f:
        tags.append("`Matrix Rotation`")
    if "diagonal" in f:
        tags.append("`Diagonal Sums`")
    if "snake" in f:
        tags.append("`Snake Pattern Traversal`")
    if "camera" in f or ("image" in f and "rotation" not in f):
        tags.append("`Image Processing`")
    if "inventory" in f or "shelf" in f:
        tags.append("`Inventory Calculation`")
    if "cricket" in f:
        tags.append("`Domain State Tracking`")
    if "vehicle" in f:
        tags.append("`Multilevel Inheritance`")
    if "student" in f or "university" in f:
        tags.append("`Class Hierarchies`")
    if "bits" in f:
        tags.append("`Bit Counting`")
    if "power" in f:
        tags.append("`Power Calculation`")
    if "length" in f:
        tags.append("`String Length`")
    if "account" in f:
        tags.append("`Validation Logic`")
    if "sum" in f and "inventory" not in f:
        tags.append("`Recursive Sum`")
    if "mighty" in f or "forest" in f:
        tags.append("`Element Search`")
    if "revers" in f:
        tags.append("`Word Reversal`")
    if "complexity" in f:
        tags.append("`Sentence Analysis`")
    if "character" in f:
        tags.append("`Character Frequency`")
    if "laptop" in f:
        tags.append("`Decision Modeling`")
    if "venue" in f:
        tags.append("`Venue Information`")
    if "player" in f and "cricket" not in f:
        tags.append("`OOP State Tracking`")
    if "wicket" in f:
        tags.append("`Wicket Tracker`")
    if "attendance" in f:
        tags.append("`Matrix Merging`")
    if "arrangement" in f:
        tags.append("`Arrangement Validation`")
    if "lines" in f and "sorted" in f:
        tags.append("`Sorted Lines Check`")

    cfg = TOPIC_CONFIG.get(topic_key, {})
    tags.append(f"`{cfg.get('display', topic_key)}`")
    return ", ".join(tags)


def extract_problem_info(folder_path: Path, repo_root: Path) -> Tuple[str, str, str, str]:
    """Extracts (topic_key, title, concepts, difficulty)."""
    folder_name = folder_path.name
    readme_path = folder_path / "README.md"

    fallback_title = folder_name
    for key in TOPIC_CONFIG:
        if folder_name.startswith(key + "-"):
            fallback_title = folder_name[len(key) + 1:].replace("-", " ").title()
            break

    topic_key = None
    title = fallback_title
    difficulty = "Medium"

    for key in TOPIC_CONFIG:
        if folder_name.startswith(key + "-") or folder_name == key:
            topic_key = key
            break

    if readme_path.is_file():
        try:
            content = readme_path.read_text(encoding="utf-8")
            lines = content.splitlines()
            first_line = lines[0].strip() if lines else ""

            match = re.match(r"^#\s*(.*?)\s*[-–—]\s*(.+)$", first_line)
            if match:
                cat_raw = match.group(1).strip().lower()
                title = match.group(2).strip()

                if not topic_key:
                    if "1d" in cat_raw:
                        topic_key = "arrays-1d"
                    elif "2d" in cat_raw:
                        topic_key = "arrays-2d"
                    elif "class" in cat_raw:
                        topic_key = "class-and-objects"
                    elif "inheritance" in cat_raw:
                        topic_key = "inheritance"
                    elif "recursion" in cat_raw:
                        topic_key = "recursion"
                    elif "string" in cat_raw:
                        topic_key = "strings"

            diff_match = re.search(r"Difficulty-(Easy|Medium|Hard)", content, re.IGNORECASE)
            if diff_match:
                difficulty = diff_match.group(1).capitalize()
        except Exception:
            pass

    if folder_name == "strings-character-count-1":
        title = "Character Count"
    if folder_name == "arrays-2d-power-grid-monitoring-computing-diagonal-load-balances":
        title = "Power Grid Monitoring — Computing Diagonal Load Balances"

    if not topic_key:
        parts = folder_name.split("-")
        topic_key = parts[0] if parts else "other"

    concepts = detect_problem_concepts(folder_name, topic_key)
    return topic_key, title, concepts, difficulty


def scan_problems(repo_root: Path) -> Dict[str, List[Problem]]:
    problems_by_topic: Dict[str, List[Problem]] = {}

    search_dirs = [repo_root / "hackerrank"]
    if not any(d.is_dir() for d in search_dirs):
        search_dirs = [repo_root]

    for search_dir in search_dirs:
        for root, dirs, files in os.walk(search_dir):
            root_path = Path(root)
            java_files = [f for f in files if f.lower().endswith(".java")]
            has_readme = (root_path / "README.md").is_file() and root_path != repo_root

            if java_files or (has_readme and root_path.parent != repo_root):
                rel_path = root_path.relative_to(repo_root).as_posix()
                java_file_name = java_files[0] if java_files else "solution.java"
                java_file_rel = f"./{rel_path}/{java_file_name}"

                topic_key, title, concepts, difficulty = extract_problem_info(root_path, repo_root)

                if topic_key not in problems_by_topic:
                    problems_by_topic[topic_key] = []

                if not any(p.rel_path == rel_path for p in problems_by_topic[topic_key]):
                    problems_by_topic[topic_key].append(
                        Problem(topic_key, root_path.name, title, f"./{rel_path}", java_file_rel, concepts, difficulty)
                    )

    for key in problems_by_topic:
        problems_by_topic[key].sort(key=lambda p: p.title.lower())

    return problems_by_topic


def generate_badges(total: int) -> str:
    """Generate dynamic shield badges matching the DBMS style."""
    lines = [
        f"[![HackerRank Profile](https://img.shields.io/badge/HackerRank-{HACKERRANK_USERNAME}-00EA64?style=for-the-badge&logo=hackerrank&logoColor=white)]({HACKERRANK_PROFILE_URL})",
        f"[![Solved](https://img.shields.io/badge/Solved-{total}-2563EB?style=for-the-badge&logo=openjdk&logoColor=white)]({HACKERRANK_PROFILE_URL})",
        f"[![Difficulty](https://img.shields.io/badge/Difficulty-Medium-F59E0B?style=for-the-badge)]({HACKERRANK_PROFILE_URL})",
        f"[![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)]({GITHUB_REPO_URL})",
        f"[![Platform](https://img.shields.io/badge/Platform-HackerRank-00EA64?style=for-the-badge&logo=hackerrank&logoColor=white)]({HACKERRANK_PROFILE_URL})",
        f"[![Views](https://komarev.com/ghpvc/?username={GITHUB_USER}-{REPO_NAME}&label=Views&color=0e75b6&style=for-the-badge)]({GITHUB_REPO_URL})",
    ]
    return " ".join(lines)


def compute_proportional_percentages(counts: List[int], total: int, decimals: int = 1) -> List[float]:
    """
    Computes exact proportional percentages that sum to 100.0%.
    Uses Hare-Niemeyer (largest remainder) distribution to eliminate rounding drift.
    """
    if total == 0:
        return [0.0] * len(counts)

    factor = 10 ** decimals
    raw_shares = [(c / total) * 100 * factor for c in counts]
    base = [int(s) for s in raw_shares]
    diff = int(round(100 * factor - sum(base)))

    remainders = [(raw_shares[i] - base[i], i) for i in range(len(counts))]
    remainders.sort(key=lambda x: x[0], reverse=True)

    for i in range(diff):
        base[remainders[i][1]] += 1

    return [b / factor for b in base]


def generate_stats_table(problems_by_topic: Dict[str, List[Problem]]) -> str:
    """Generate progress dashboard table with ASCII visual bars guaranteed to sum to 100.0%."""
    total = sum(len(probs) for probs in problems_by_topic.values())

    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])
    all_keys = ordered_keys + remaining_keys

    counts = [len(problems_by_topic[k]) for k in all_keys]
    pcts = compute_proportional_percentages(counts, total, decimals=1)

    def progress_bar(pct: float, count: int) -> str:
        if count == 0:
            filled = 0
        else:
            filled = max(1, int(round(pct / 10)))
        bar = "█" * filled + "░" * (10 - filled)
        return f"`{bar}` {pct:.1f}%"

    rows = [
        "| Category | Solved | Share of Solutions | Key Concepts |",
        "|:---|:---:|:---|:---|",
    ]

    for i, key in enumerate(all_keys):
        cfg = TOPIC_CONFIG.get(key, {
            "display": key.replace("-", " ").title(),
            "icon": "📌",
            "key_concepts": "Problem solving",
        })
        count = counts[i]
        pct = pcts[i]
        bar_str = progress_bar(pct, count)
        rows.append(f"| {cfg['icon']} **{cfg['display']}** | **{count}** | {bar_str} | {cfg['key_concepts']} |")

    rows.append(f"| 🎯 **Total** | **{total}** | `██████████` 100.0% | **All Topics** |")
    return "\n".join(rows)


def generate_collapsible_problem_index(problems_by_topic: Dict[str, List[Problem]]) -> str:
    """Generate collapsible accordion sections for each topic matching DBMS style."""
    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])

    sections = [
        "> 💡 **Tip:** Solutions are grouped into collapsible drawers below. Click any section to expand or collapse. For the full master list, see [`SOLUTIONS.md`](./SOLUTIONS.md).\n"
    ]

    global_id = 1
    for key in ordered_keys + remaining_keys:
        cfg = TOPIC_CONFIG.get(key, {
            "display": key.replace("-", " ").title(),
            "icon": "📌",
        })
        probs = problems_by_topic[key]

        drawer = [
            f"<details open>",
            f"<summary><b>{cfg['icon']} {cfg['display']} ({len(probs)})</b> — <i>Click to expand/collapse</i></summary>\n",
            "| # | Problem Title | Solution | Key Concepts / Topics |",
            "|:---:|:---|:---:|:---|",
        ]
        for p in probs:
            drawer.append(f"| {global_id} | [{p.title}]({p.rel_path}) | [💻 Java]({p.java_file_rel}) | {p.concepts} |")
            global_id += 1

        drawer.append("\n</details>\n")
        sections.append("\n".join(drawer))

    return "\n".join(sections)


def generate_solutions_md(problems_by_topic: Dict[str, List[Problem]]) -> str:
    """Generates comprehensive dedicated SOLUTIONS.md catalog."""
    total = sum(len(probs) for probs in problems_by_topic.values())

    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])

    lines = [
        "# 📑 Complete Java Solutions Catalog",
        "",
        f"This catalog lists all **{total}** HackerRank Java practice solutions synced from HackerRank profile [**@{HACKERRANK_USERNAME}**]({HACKERRANK_PROFILE_URL}).",
        "",
        "[⬅️ Return to README](./README.md)",
        "",
        "---",
        "",
        "| # | Problem Title | Solution | Category | Key Concepts / Topics |",
        "|:---:|:---|:---:|:---:|:---|",
    ]

    global_id = 1
    for key in ordered_keys + remaining_keys:
        cfg = TOPIC_CONFIG.get(key, {
            "display": key.replace("-", " ").title(),
        })
        for p in problems_by_topic[key]:
            lines.append(f"| {global_id} | [{p.title}]({p.rel_path}) | [💻 Java]({p.java_file_rel}) | **{cfg['display']}** | {p.concepts} |")
            global_id += 1

    lines.append("")
    lines.append("---")
    lines.append(f"<sub>Auto-generated by `scripts/update_readme.py` • Synced from HackerRank: [{HACKERRANK_USERNAME}]({HACKERRANK_PROFILE_URL})</sub>")
    return "\n".join(lines)


def build_full_readme(problems_by_topic: Dict[str, List[Problem]]) -> str:
    """Builds the complete DBMS-style README from scratch."""
    total = sum(len(probs) for probs in problems_by_topic.values())
    badges = generate_badges(total)
    stats_table = generate_stats_table(problems_by_topic)
    problem_index = generate_collapsible_problem_index(problems_by_topic)

    content = f"""# ☕ Java — Data Structures & OOP Solutions

A curated collection of Java solutions to **HackerRank** challenges, maintained for coursework, interview preparation, and mastery of data structures, algorithms, and object-oriented design.

{BADGES_START}
{badges}
{BADGES_END}

---

## 📌 Overview

This repository automatically tracks and synchronizes my Java programming practice questions directly from my HackerRank profile: [**@{HACKERRANK_USERNAME}**]({HACKERRANK_PROFILE_URL}). Each accepted submission is committed automatically, reflecting an active history of problems attempted and mastered.

- **HackerRank Profile:** [hackerrank.com/profile/{HACKERRANK_USERNAME}]({HACKERRANK_PROFILE_URL})
- **Language & Runtime:** Java (OpenJDK standard)
- **Automatic Sync:** Connected with automated count and index updates via GitHub Actions CI.
- **Organization:** Each problem is contained in an isolated directory with its problem statement (`README.md`) and optimal Java solution (`solution.java`).

---

## 📊 Progress Dashboard

{STATS_START}
{stats_table}
{STATS_END}

---

## 📑 Problem Index

The table below is **automatically generated and updated** whenever new solutions are added:

{PROBLEMS_START}
{problem_index}
{PROBLEMS_END}

---

## 🧠 Topics & Key Concepts Covered

- **Arrays (1D & 2D):** Median finding, filtering, matrix traversal, rotation, diagonal load balances, and robotic snake traversals.
- **Classes & Objects:** Encapsulation, state management, delivery tracking systems, and domain modeling.
- **Inheritance & Polymorphism:** Class hierarchies, method overriding, and vehicle/student management systems.
- **Recursion:** Divide & conquer, bit counting in device monitoring, recursive power/string calculation, and account number validation.
- **String Manipulation:** Character frequency counting, word reversal for teleprompters, and sentence complexity analysis.

---

## 📂 Repository Structure

```
JAVA/
├── .github/
│   └── workflows/
│       └── update-readme.yml      # CI/CD workflow for automated counter & table generation
├── scripts/
│   └── update_readme.py           # Python script that counts solutions and syncs README.md
├── hackerrank/
│   └── medium/
│       ├── arrays-1d-*/           # 1D Array problems
│       ├── arrays-2d-*/           # 2D Array / Matrix problems
│       ├── class-and-objects-*/   # OOP & encapsulation problems
│       ├── inheritance-*/         # Inheritance & polymorphism problems
│       ├── recursion-*/           # Recursive algorithm problems
│       └── strings-*/             # String manipulation problems
├── SOLUTIONS.md                   # Comprehensive flat solutions catalog
└── README.md                      # Repository overview, dynamic stats, and problem index
```

---

## ⚡ Automation & Local Usage

This repository features an **automated counting and indexing program**:

### 1. Automatic GitHub Actions CI
Whenever a new solution is committed (via PushMyCode, sync tool, or git push), the [GitHub Actions Workflow](.github/workflows/update-readme.yml) triggers automatically:
1. Discovers all problem folders and Java solutions.
2. Extracts problem titles, categories, and relative paths.
3. Computes progress share percentages and visual progress bars.
4. Generates formatted collapsible tables and updates `README.md` and `SOLUTIONS.md`.
5. Automatically commits and pushes any updates.

### 2. Run Manually / Locally
You can also run the count updater locally anytime:

```bash
python scripts/update_readme.py
```

---

<div align="center">
  <sub>Maintained by <a href="https://github.com/{GITHUB_USER}">{GITHUB_USER}</a> • HackerRank: <a href="{HACKERRANK_PROFILE_URL}">@{HACKERRANK_USERNAME}</a> • Built with Python & GitHub Actions</sub>
</div>
"""
    return content


def update_readme_content(original_content: str, problems_by_topic: Dict[str, List[Problem]]) -> str:
    # If the file lacks DBMS-style markers or headers, regenerate full layout
    if BADGES_START not in original_content or STATS_START not in original_content or PROBLEMS_START not in original_content:
        return build_full_readme(problems_by_topic)

    total = sum(len(probs) for probs in problems_by_topic.values())
    content = original_content

    # 1. Update Badges
    new_badges = generate_badges(total)
    content = re.sub(
        rf"{re.escape(BADGES_START)}.*?{re.escape(BADGES_END)}",
        f"{BADGES_START}\n{new_badges}\n{BADGES_END}",
        content,
        flags=re.DOTALL,
    )

    # 2. Update Stats Table
    new_stats = generate_stats_table(problems_by_topic)
    content = re.sub(
        rf"{re.escape(STATS_START)}.*?{re.escape(STATS_END)}",
        f"{STATS_START}\n{new_stats}\n{STATS_END}",
        content,
        flags=re.DOTALL,
    )

    # 3. Update Collapsible Problem Index
    new_problems = generate_collapsible_problem_index(problems_by_topic)
    content = re.sub(
        rf"{re.escape(PROBLEMS_START)}.*?{re.escape(PROBLEMS_END)}",
        f"{PROBLEMS_START}\n{new_problems}\n{PROBLEMS_END}",
        content,
        flags=re.DOTALL,
    )

    return content


def main():
    parser = argparse.ArgumentParser(description="Update README.md and SOLUTIONS.md counts and problem index.")
    parser.add_argument(
        "--repo-dir",
        type=Path,
        default=Path(__file__).resolve().parent.parent,
        help="Path to repository root (default: parent of scripts/)",
    )
    parser.add_argument(
        "--check",
        action="store_true",
        help="Check if README.md and SOLUTIONS.md are up to date without writing changes. Exits with 1 if outdated.",
    )
    parser.add_argument(
        "--write",
        action="store_true",
        default=True,
        help="Write updated contents to README.md and SOLUTIONS.md (default: True).",
    )
    args = parser.parse_args()

    repo_root = args.repo_dir.resolve()
    readme_path = repo_root / "README.md"
    solutions_path = repo_root / "SOLUTIONS.md"

    if not readme_path.is_file():
        print(f"Error: README.md not found at {readme_path}", file=sys.stderr)
        sys.exit(1)

    print(f"Scanning repository at: {repo_root}")
    problems_by_topic = scan_problems(repo_root)
    total_problems = sum(len(p) for p in problems_by_topic.values())
    print(f"Discovered {total_problems} problems across {len(problems_by_topic)} topics.")

    for topic_key, probs in problems_by_topic.items():
        disp = TOPIC_CONFIG.get(topic_key, {}).get("display", topic_key)
        print(f"  - {disp}: {len(probs)} problems")

    with open(readme_path, "r", encoding="utf-8") as f:
        original_readme = f.read()

    updated_readme = update_readme_content(original_readme, problems_by_topic)
    updated_solutions = generate_solutions_md(problems_by_topic)

    original_solutions = ""
    if solutions_path.is_file():
        with open(solutions_path, "r", encoding="utf-8") as f:
            original_solutions = f.read()

    readme_up_to_date = (original_readme == updated_readme)
    solutions_up_to_date = (original_solutions == updated_solutions)

    if readme_up_to_date and solutions_up_to_date:
        print("README.md and SOLUTIONS.md are already up to date!")
        sys.exit(0)

    if args.check:
        print("Documentation is outdated! Run 'python scripts/update_readme.py' to update.", file=sys.stderr)
        sys.exit(1)

    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(updated_readme)

    with open(solutions_path, "w", encoding="utf-8") as f:
        f.write(updated_solutions)

    print(f"Successfully updated {readme_path} and {solutions_path} (Total Solutions: {total_problems})")


if __name__ == "__main__":
    main()
