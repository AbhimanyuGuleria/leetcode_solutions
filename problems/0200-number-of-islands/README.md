# 200. [Number of Islands](https://leetcode.com/problems/number-of-islands/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/number-of-islands/](https://leetcode.com/problems/number-of-islands/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `34 ms`
- **Memory:** `16.2 MB`
- **Solved Date:** April 21, 2026 (17:29 UTC)

---

## 💻 Solution
```cpp
#include <vector>

class Solution {
public:
    int numIslands(std::vector<std::vector<char>>& grid) {
        if (grid.empty()) return 0;
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        return count;
    }

private:
    void dfs(std::vector<std::vector<char>>& grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);
    }
};
```
