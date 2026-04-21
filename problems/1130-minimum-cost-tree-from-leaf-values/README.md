# 1130. [Minimum Cost Tree From Leaf Values](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/](https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `12.3 MB`
- **Solved Date:** April 21, 2026 (17:29 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <algorithm>
#include <climits>

class Solution {
public:
    int mctFromLeafValues(std::vector<int>& arr) {
        int n = arr.size();
        std::vector<std::vector<int>> max_val(n, std::vector<int>(n));
        
        for (int i = 0; i < n; ++i) {
            max_val[i][i] = arr[i];
            for (int j = i + 1; j < n; ++j) {
                max_val[i][j] = std::max(max_val[i][j - 1], arr[j]);
            }
        }

        std::vector<std::vector<int>> dp(n, std::vector<int>(n, 0));

        for (int len = 2; len <= n; ++len) {
            for (int i = 0; i <= n - len; ++i) {
                int j = i + len - 1;
                dp[i][j] = INT_MAX;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = std::min(dp[i][j], dp[i][k] + dp[k + 1][j] + max_val[i][k] * max_val[k + 1][j]);
                }
            }
        }

        return dp[0][n - 1];
    }
};
```
