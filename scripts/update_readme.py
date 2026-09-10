#!/usr/bin/env python3
"""
scripts/update_readme.py

Automates scanning the repository for HackerRank / Java solutions,
calculating solution counts (global and per-topic), and updating README.md:
  1. Header badge: ![Problems Solved](...badge...)
  2. Intro text: "**X medium-difficulty** Java solutions"
  3. Overview table: Total Solutions
  4. Topics Covered table: per-topic counts
  5. Problem Index: sequentially numbered tables organized by topic with links
  6. HackerRank profile integration: @saisrikar_b_2021

Features:
  - Supports both in-place section updates and full recovery if an external tool
    (e.g., PushMyCode) overwrites README.md with generic template text.
  - Can be run locally or via GitHub Actions CI workflow.

Usage:
  python scripts/update_readme.py          # Updates README.md in place
  python scripts/update_readme.py --check  # Verifies if README.md is up to date
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

PROFILE_URL = "https://www.hackerrank.com/profile/saisrikar_b_2021"
PROFILE_HANDLE = "saisrikar_b_2021"

TOPIC_CONFIG: Dict[str, Dict[str, str]] = {
    "arrays-1d": {
        "display": "Arrays (1D)",
        "section_header": "### 🔢 Arrays — 1D",
        "key_concepts": "Median finding, filtering",
    },
    "arrays-2d": {
        "display": "Arrays (2D)",
        "section_header": "### 🔢 Arrays — 2D",
        "key_concepts": "Matrix traversal, rotation, diagonal sums, snake patterns",
    },
    "class-and-objects": {
        "display": "Classes & Objects",
        "section_header": "### 🏗️ Classes & Objects",
        "key_concepts": "Encapsulation, state management, domain modeling",
    },
    "inheritance": {
        "display": "Inheritance",
        "section_header": "### 🧬 Inheritance",
        "key_concepts": "Class hierarchies, method overriding",
    },
    "recursion": {
        "display": "Recursion",
        "section_header": "### 🔁 Recursion",
        "key_concepts": "Divide & conquer, bit counting, validation",
    },
    "strings": {
        "display": "Strings",
        "section_header": "### 🔤 Strings",
        "key_concepts": "Parsing, reversal, character analysis",
    },
}

TOPICS_START_MARKER = "<!-- TOPICS_TABLE_START -->"
TOPICS_END_MARKER = "<!-- TOPICS_TABLE_END -->"
INDEX_START_MARKER = "<!-- PROBLEM_INDEX_START -->"
INDEX_END_MARKER = "<!-- PROBLEM_INDEX_END -->"


class Problem:
    def __init__(self, topic_key: str, folder_name: str, title: str, rel_path: str):
        self.topic_key = topic_key
        self.folder_name = folder_name
        self.title = title
        self.rel_path = rel_path.replace("\\", "/")


def extract_problem_info(folder_path: Path, repo_root: Path) -> Tuple[str, str]:
    folder_name = folder_path.name
    readme_path = folder_path / "README.md"

    fallback_title = folder_name
    for key in TOPIC_CONFIG:
        if folder_name.startswith(key + "-"):
            fallback_title = folder_name[len(key) + 1:].replace("-", " ").title()
            break

    topic_key = None
    title = fallback_title

    for key in TOPIC_CONFIG:
        if folder_name.startswith(key + "-") or folder_name == key:
            topic_key = key
            break

    if readme_path.is_file():
        try:
            with open(readme_path, "r", encoding="utf-8") as f:
                first_line = f.readline().strip()
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
        except Exception:
            pass

    if folder_name == "strings-character-count-1":
        title = "Character Count"
    if folder_name == "arrays-2d-power-grid-monitoring-computing-diagonal-load-balances":
        title = "Power Grid Monitoring — Computing Diagonal Load Balances"

    if not topic_key:
        parts = folder_name.split("-")
        topic_key = parts[0] if parts else "other"

    return topic_key, title


def scan_problems(repo_root: Path) -> Dict[str, List[Problem]]:
    problems_by_topic: Dict[str, List[Problem]] = {}

    search_dirs = [repo_root / "hackerrank"]
    if not any(d.is_dir() for d in search_dirs):
        search_dirs = [repo_root]

    for search_dir in search_dirs:
        for root, dirs, files in os.walk(search_dir):
            root_path = Path(root)
            has_java = any(f.lower().endswith(".java") for f in files)
            has_readme = (root_path / "README.md").is_file() and root_path != repo_root

            if has_java or (has_readme and root_path.parent != repo_root):
                rel_path = root_path.relative_to(repo_root).as_posix()
                topic_key, title = extract_problem_info(root_path, repo_root)

                if topic_key not in problems_by_topic:
                    problems_by_topic[topic_key] = []

                if not any(p.rel_path == rel_path for p in problems_by_topic[topic_key]):
                    problems_by_topic[topic_key].append(
                        Problem(topic_key, root_path.name, title, rel_path)
                    )

    for key in problems_by_topic:
        problems_by_topic[key].sort(key=lambda p: p.title.lower())

    return problems_by_topic


def generate_topics_table(problems_by_topic: Dict[str, List[Problem]]) -> str:
    rows = [
        "| Topic | Count | Key Concepts |",
        "|:---|:---:|:---|",
    ]

    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])

    for key in ordered_keys + remaining_keys:
        cfg = TOPIC_CONFIG.get(key, {
            "display": key.replace("-", " ").title(),
            "key_concepts": "Problem solving, algorithms",
        })
        count = len(problems_by_topic[key])
        rows.append(f"| **{cfg['display']}** | {count} | {cfg['key_concepts']} |")

    return "\n".join(rows)


def generate_problem_index(problems_by_topic: Dict[str, List[Problem]]) -> str:
    sections = []
    current_index = 1

    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])

    for key in ordered_keys + remaining_keys:
        cfg = TOPIC_CONFIG.get(key, {
            "display": key.replace("-", " ").title(),
            "section_header": f"### 📌 {key.replace('-', ' ').title()}",
        })
        section_lines = [
            cfg["section_header"],
            "",
            "| # | Problem | Link |",
            "|:---:|:---|:---:|",
        ]
        for prob in problems_by_topic[key]:
            section_lines.append(f"| {current_index} | {prob.title} | [Solution]({prob.rel_path}) |")
            current_index += 1

        sections.append("\n".join(section_lines))

    return "\n\n".join(sections)


def build_full_readme(problems_by_topic: Dict[str, List[Problem]]) -> str:
    total_count = sum(len(probs) for probs in problems_by_topic.values())
    topics_table = generate_topics_table(problems_by_topic)
    problem_index = generate_problem_index(problems_by_topic)

    ordered_keys = [k for k in TOPIC_CONFIG if k in problems_by_topic]
    remaining_keys = sorted([k for k in problems_by_topic if k not in TOPIC_CONFIG])
    topics_names = [
        TOPIC_CONFIG.get(k, {}).get("display", k.replace("-", " ").title()).split()[0]
        for k in (ordered_keys + remaining_keys)
    ]
    topics_summary = ", ".join(dict.fromkeys(topics_names))

    template = f"""<div align="center">

# ☕ Java — Data Structures & OOP Solutions

![Language](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Problems Solved](https://img.shields.io/badge/Problems_Solved-{total_count}-blue?style=for-the-badge)
![Difficulty](https://img.shields.io/badge/Difficulty-Medium-f5a623?style=for-the-badge)
[![HackerRank](https://img.shields.io/badge/HackerRank-{PROFILE_HANDLE}-00EA64?style=for-the-badge&logo=hackerrank&logoColor=white)]({PROFILE_URL})

A curated collection of **{total_count} medium-difficulty** Java solutions from [HackerRank]({PROFILE_URL}), organized by topic. Each solution demonstrates clean code practices, efficient algorithms, and solid object-oriented design.

</div>

---

## 📋 Table of Contents

- [Overview](#-overview)
- [Topics Covered](#-topics-covered)
- [Problem Index](#-problem-index)
- [Repository Structure](#-repository-structure)
- [How to Run](#-how-to-run)
- [Contributing](#-contributing)

---

## 🔍 Overview

| Metric | Value |
|:---|:---|
| **Platform** | HackerRank |
| **Profile** | [@{PROFILE_HANDLE}]({PROFILE_URL}) |
| **Language** | Java |
| **Difficulty** | Medium |
| **Total Solutions** | {total_count} |
| **Topics** | {topics_summary} |

---

## 🧩 Topics Covered

{TOPICS_START_MARKER}
{topics_table}
{TOPICS_END_MARKER}

> **Note:** Some problems span multiple topics (e.g., a Classes & Objects problem may also use arrays internally).

---

## 📝 Problem Index

{INDEX_START_MARKER}
{problem_index}
{INDEX_END_MARKER}

---

## 📂 Repository Structure

```
JAVA/
└── hackerrank/
    └── medium/
        ├── arrays-1d-*/           # 1D Array problems
        ├── arrays-2d-*/           # 2D Array / Matrix problems
        ├── class-and-objects-*/   # OOP & encapsulation problems
        ├── inheritance-*/         # Inheritance & polymorphism problems
        ├── recursion-*/           # Recursive algorithm problems
        └── strings-*/             # String manipulation problems
```

Each problem directory contains the Java source file(s) with the complete solution.

---

## ▶️ How to Run

**Prerequisites:** Java 8+ (JDK) installed on your system.

```bash
# Clone the repository
git clone https://github.com/Saisrikar20/JAVA.git
cd JAVA

# Navigate to a problem directory
cd hackerrank/medium/<problem-name>

# Compile and run
javac Solution.java
java Solution
```

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome! Feel free to:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/new-solution`)
3. **Commit** your changes (`git commit -m "Add solution for ..."`)
4. **Push** to the branch (`git push origin feature/new-solution`)
5. **Open** a Pull Request

---

<div align="center">

**⭐ If you find these solutions helpful, consider giving this repo a star!**

Made with ☕ and Java by [@{PROFILE_HANDLE}]({PROFILE_URL})

</div>
"""
    return template


def update_readme_content(original_content: str, problems_by_topic: Dict[str, List[Problem]]) -> str:
    total_count = sum(len(probs) for probs in problems_by_topic.values())

    # If the file has been overwritten by PushMyCode or lacks curated structure, rebuild full template
    if "# ☕ Java" not in original_content or "## 📝 Problem Index" not in original_content:
        return build_full_readme(problems_by_topic)

    content = original_content

    # 1. Update/Add HackerRank profile badge
    profile_badge = f"[![HackerRank](https://img.shields.io/badge/HackerRank-{PROFILE_HANDLE}-00EA64?style=for-the-badge&logo=hackerrank&logoColor=white)]({PROFILE_URL})"
    badge_pattern = r"\[?!\[[^\]]*\]\(https://img\.shields\.io/badge/[^)\n]*hackerrank[^)\n]*\)(?:\]\([^)\n]*\))?"
    content = re.sub(badge_pattern, profile_badge, content)

    # 2. Update badge for problems solved
    content = re.sub(
        r"(!\[Problems Solved\]\(https://img\.shields\.io/badge/Problems_Solved-)\d+(-blue\?style=for-the-badge\))",
        rf"\g<1>{total_count}\g<2>",
        content,
    )

    # 3. Intro sentence
    content = re.sub(
        r"(\bcurated collection of \*\*)\d+( medium-difficulty\*\* Java solutions from )\[HackerRank\]\([^)]*\)",
        rf"\g<1>{total_count}\g<2>[HackerRank]({PROFILE_URL})",
        content,
    )

    # 4. Overview table: Total Solutions & Profile
    content = re.sub(
        r"(\|\s*\*\*Total Solutions\*\*\s*\|\s*)\d+(\s*\|)",
        rf"\g<1>{total_count}\g<2>",
        content,
    )
    if "| **Profile** |" not in content and "| **Platform** |" in content:
        content = re.sub(
            r"(\|\s*\*\*Platform\*\*\s*\|\s*HackerRank\s*\|)",
            rf"\g<1>\n| **Profile** | [@{PROFILE_HANDLE}]({PROFILE_URL}) |",
            content,
        )

    # 5. Topics Covered table
    new_topics_table = generate_topics_table(problems_by_topic)
    if TOPICS_START_MARKER in content and TOPICS_END_MARKER in content:
        pattern = re.escape(TOPICS_START_MARKER) + r".*?" + re.escape(TOPICS_END_MARKER)
        replacement = f"{TOPICS_START_MARKER}\n{new_topics_table}\n{TOPICS_END_MARKER}"
        content = re.sub(pattern, replacement, content, flags=re.DOTALL)
    else:
        topics_pattern = r"(## 🧩 Topics Covered\s*\n\n)(?:\|[^\n]+\|\n)+(\s*\n> \*\*Note:\*\*)"
        if re.search(topics_pattern, content):
            content = re.sub(
                topics_pattern,
                rf"\g<1>{TOPICS_START_MARKER}\n{new_topics_table}\n{TOPICS_END_MARKER}\g<2>",
                content,
            )

    # 6. Problem Index
    new_problem_index = generate_problem_index(problems_by_topic)
    if INDEX_START_MARKER in content and INDEX_END_MARKER in content:
        pattern = re.escape(INDEX_START_MARKER) + r".*?" + re.escape(INDEX_END_MARKER)
        replacement = f"{INDEX_START_MARKER}\n{new_problem_index}\n{INDEX_END_MARKER}"
        content = re.sub(pattern, replacement, content, flags=re.DOTALL)
    else:
        index_pattern = r"(## 📝 Problem Index\s*\n\n)(.*?)(\n---\s*\n+## 📂 Repository Structure)"
        if re.search(index_pattern, content, flags=re.DOTALL):
            content = re.sub(
                index_pattern,
                rf"\g<1>{INDEX_START_MARKER}\n{new_problem_index}\n{INDEX_END_MARKER}\g<3>",
                content,
                flags=re.DOTALL,
            )

    return content


def main():
    parser = argparse.ArgumentParser(description="Update README.md counts, profile, and problem index.")
    parser.add_argument(
        "--repo-dir",
        type=Path,
        default=Path(__file__).resolve().parent.parent,
        help="Path to repository root (default: parent of scripts/)",
    )
    parser.add_argument(
        "--check",
        action="store_true",
        help="Check if README.md is up to date without writing changes. Exits with 1 if outdated.",
    )
    parser.add_argument(
        "--write",
        action="store_true",
        default=True,
        help="Write updated contents to README.md (default: True).",
    )
    args = parser.parse_args()

    repo_root = args.repo_dir.resolve()
    readme_path = repo_root / "README.md"

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
        original_content = f.read()

    updated_content = update_readme_content(original_content, problems_by_topic)

    if original_content == updated_content:
        print("README.md is already up to date!")
        sys.exit(0)

    if args.check:
        print("README.md is outdated! Run 'python scripts/update_readme.py' to update.", file=sys.stderr)
        sys.exit(1)

    with open(readme_path, "w", encoding="utf-8") as f:
        f.write(updated_content)

    print(f"Successfully updated {readme_path} (Total Solutions: {total_problems})")


if __name__ == "__main__":
    main()
