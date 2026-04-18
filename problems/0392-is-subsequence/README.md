# 392. [Is Subsequence](https://leetcode.com/problems/is-subsequence/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/is-subsequence/](https://leetcode.com/problems/is-subsequence/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `42.9 MB`
- **Solved Date:** April 18, 2026 (06:17 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length();
    }
}

```
