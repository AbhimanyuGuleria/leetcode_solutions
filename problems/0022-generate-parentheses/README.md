# 22. [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/generate-parentheses/](https://leetcode.com/problems/generate-parentheses/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `3 ms`
- **Memory:** `44.8 MB`
- **Solved Date:** June 27, 2026 (07:37 UTC)

---

## 💻 Solution
```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, "", 0, 0, n);
        return result;
    }
    private void backtrack(List<String> result, String current, int open, int close, int n){
        if(open == n && close == n){
            result.add(current);
            return;
        }
        if(open < n){
            backtrack(result, current +"(", open + 1, close, n);
        }
        if(close < open){
            backtrack(result, current +")", open, close+1, n);
        }
    }
}
```
