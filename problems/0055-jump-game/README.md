# 55. [Jump Game](https://leetcode.com/problems/jump-game/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/jump-game/](https://leetcode.com/problems/jump-game/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `52.4 MB`
- **Solved Date:** April 21, 2026 (17:24 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    bool canJump(std::vector<int>& nums) {
        int reachable = 0;
        int n = nums.size();
        
        for (int i = 0; i < n; ++i) {
            if (i > reachable) {
                return false;
            }
            reachable = std::max(reachable, i + nums[i]);
            if (reachable >= n - 1) {
                return true;
            }
        }
        
        return true;
    }
};
```
