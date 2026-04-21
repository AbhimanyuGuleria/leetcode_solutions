# 72. [Edit Distance](https://leetcode.com/problems/edit-distance/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/edit-distance/](https://leetcode.com/problems/edit-distance/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `3 ms`
- **Memory:** `13 MB`
- **Solved Date:** April 21, 2026 (17:35 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <string>
#include <algorithm>

class Solution {
public:
    int minDistance(std::string word1, std::string word2) {
        int m = word1.length();
        int n = word2.length();
        std::vector<std::vector<int>> dp(m + 1, std::vector<int>(n + 1));

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + std::min({dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]});
                }
            }
        }

        return dp[m][n];
    }
};
```
