# 583. [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/delete-operation-for-two-strings/](https://leetcode.com/problems/delete-operation-for-two-strings/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `6 ms`
- **Memory:** `45.9 MB`
- **Solved Date:** April 21, 2026 (17:48 UTC)

---

## 💻 Solution
```java
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        int lcs = dp[m][n];
        
        return m + n - 2 * lcs;
    }
}
```
