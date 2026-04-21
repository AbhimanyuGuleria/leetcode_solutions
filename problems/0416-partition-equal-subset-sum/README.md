# 416. [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/partition-equal-subset-sum/](https://leetcode.com/problems/partition-equal-subset-sum/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `28 ms`
- **Memory:** `13.4 MB`
- **Solved Date:** April 21, 2026 (17:26 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <numeric>

class Solution {
public:
    bool canPartition(std::vector<int>& nums) {
        int totalSum = std::accumulate(nums.begin(), nums.end(), 0);
        
        if (totalSum % 2 != 0) {
            return false;
        }
        
        int target = totalSum / 2;
        std::vector<bool> dp(target + 1, false);
        dp[0] = true;
        
        for (int num : nums) {
            for (int i = target; i >= num; --i) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
            if (dp[target]) return true;
        }
        
        return dp[target];
    }
};
```
