import os
import sys
import json
import time
import datetime
import subprocess
import requests

LANG_EXTENSIONS = {
    'python': 'py',
    'python3': 'py',
    'cpp': 'cpp',
    'c': 'c',
    'java': 'java',
    'csharp': 'cs',
    'javascript': 'js',
    'typescript': 'ts',
    'golang': 'go',
    'go': 'go',
    'rust': 'rs',
    'kotlin': 'kt',
    'swift': 'swift',
    'ruby': 'rb',
    'php': 'php',
    'scala': 'scala',
    'mysql': 'sql',
    'sql': 'sql',
    'mssql': 'sql',
    'oraclesql': 'sql',
    'postgresql': 'sql',
    'bash': 'sh',
}

DIFF_BADGES = {
    'Easy': '🟢 Easy',
    'Medium': '🟡 Medium',
    'Hard': '🔴 Hard'
}

def sync():
    session_token = os.environ.get("LEETCODE_SESSION")
    if not session_token:
        print("ERROR: LEETCODE_SESSION secret is missing!")
        sys.exit(1)

    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36",
        "Referer": "https://leetcode.com/",
    }
    cookies = {"LEETCODE_SESSION": session_token}

    # Fetch problem catalog for official IDs and difficulty
    print("Fetching catalog...")
    catalog = {}
    try:
        cat_resp = requests.get("https://leetcode.com/api/problems/all/", headers=headers, cookies=cookies)
        if cat_resp.status_code == 200:
            diff_map = {1: "Easy", 2: "Medium", 3: "Hard"}
            for item in cat_resp.json().get("stat_status_pairs", []):
                stat = item.get("stat", {})
                slug = stat.get("question__title_slug")
                fid = stat.get("frontend_question_id")
                diff_lvl = item.get("difficulty", {}).get("level", 1)
                if slug:
                    catalog[slug] = {
                        "id": int(fid) if str(fid).isdigit() else fid,
                        "title": stat.get("question__title"),
                        "difficulty": diff_map.get(diff_lvl, "Medium")
                    }
    except Exception as e:
        print(f"Warning: Could not fetch catalog: {e}")

    offset = 0
    all_submissions = []
    print("Fetching recent submissions from LeetCode...")
    while True:
        url = f"https://leetcode.com/api/submissions/?offset={offset}&limit=20"
        resp = requests.get(url, headers=headers, cookies=cookies)
        if resp.status_code != 200:
            print(f"Failed to fetch submissions at offset {offset}: status {resp.status_code}")
            break
        data = resp.json()
        subs = data.get("submissions_dump", [])
        if not subs:
            break
        all_submissions.extend(subs)
        if not data.get("has_next"):
            break
        offset += len(subs)
        time.sleep(0.3)

    accepted = [s for s in all_submissions if s.get("status_display") == "Accepted"]
    accepted.sort(key=lambda s: s["timestamp"])

    repo_dir = "."
    problems_dir = os.path.join(repo_dir, "problems")
    os.makedirs(problems_dir, exist_ok=True)

    new_commits = 0
    for sub in accepted:
        ts = sub["timestamp"]
        dt = datetime.datetime.fromtimestamp(ts, tz=datetime.timezone.utc)
        date_str = dt.strftime("%Y-%m-%d %H:%M:%S +0000")

        title_slug = sub.get("title_slug", "unknown")
        cat_entry = catalog.get(title_slug, {})
        problem_id = cat_entry.get("id") or sub.get("frontend_id") or sub.get("question_id")
        problem_title = cat_entry.get("title") or sub.get("title", title_slug)
        difficulty = cat_entry.get("difficulty", "Medium")
        diff_badge = DIFF_BADGES.get(difficulty, difficulty)

        lang = sub.get("lang", "txt")
        lang_name = sub.get("lang_name", lang.capitalize())
        ext = LANG_EXTENSIONS.get(lang.lower(), lang)
        code = sub.get("code", "")
        runtime = sub.get("runtime", "N/A")
        memory = sub.get("memory", "N/A")

        folder_name = f"{int(problem_id):04d}-{title_slug}" if str(problem_id).isdigit() else f"{problem_id}-{title_slug}"
        prob_folder = os.path.join(problems_dir, folder_name)
        os.makedirs(prob_folder, exist_ok=True)

        sol_filename = f"Solution.{ext}"
        sol_path = os.path.join(prob_folder, sol_filename)
        
        # Check if already exists and has identical code
        already_synced = False
        if os.path.exists(sol_path):
            with open(sol_path, "r", encoding="utf-8") as f:
                if f.read().strip() == code.strip():
                    already_synced = True

        if not already_synced:
            with open(sol_path, "w", encoding="utf-8") as f:
                f.write(code)

            prob_readme = os.path.join(prob_folder, "README.md")
            readme_content = f"""# {problem_id}. [{problem_title}](https://leetcode.com/problems/{title_slug}/)

## 📌 Problem Information
- **Difficulty:** {diff_badge}
- **LeetCode Link:** [https://leetcode.com/problems/{title_slug}/](https://leetcode.com/problems/{title_slug}/)

## ⚡ Submission Stats
- **Language:** `{lang_name}`
- **Runtime:** `{runtime}`
- **Memory:** `{memory}`
- **Solved Date:** {dt.strftime('%B %d, %Y (%H:%M UTC)')}

---

## 💻 Solution
```{ext}
{code}
```
"""
            with open(prob_readme, "w", encoding="utf-8") as f:
                f.write(readme_content)

            subprocess.run(["git", "add", prob_folder], check=True)
            env = os.environ.copy()
            env["GIT_AUTHOR_DATE"] = date_str
            env["GIT_COMMITTER_DATE"] = date_str
            commit_msg = f"Solve: {problem_id}. {problem_title} ({lang_name})"
            subprocess.run(["git", "commit", "-m", commit_msg], env=env, check=True)
            new_commits += 1
            print(f"Committed new solution: {commit_msg}")

    print(f"Sync complete. {new_commits} new submissions committed.")

if __name__ == "__main__":
    sync()
