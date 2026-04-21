# 198. [House Robber](https://leetcode.com/problems/house-robber/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/house-robber/](https://leetcode.com/problems/house-robber/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `10 MB`
- **Solved Date:** April 21, 2026 (17:20 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for (int money : nums) {
            int current = std::max(prev1, money + prev2);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
};
```
