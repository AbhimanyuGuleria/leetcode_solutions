# 322. [Coin Change](https://leetcode.com/problems/coin-change/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/coin-change/](https://leetcode.com/problems/coin-change/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `19 ms`
- **Memory:** `17.8 MB`
- **Solved Date:** April 21, 2026 (17:25 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    int coinChange(std::vector<int>& coins, int amount) {
        std::vector<int> dp(amount + 1, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; ++i) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = std::min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
};
```
