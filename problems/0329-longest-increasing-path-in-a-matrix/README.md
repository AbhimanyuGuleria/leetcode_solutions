# 329. [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/longest-increasing-path-in-a-matrix/](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `18 ms`
- **Memory:** `22.4 MB`
- **Solved Date:** April 21, 2026 (17:42 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <algorithm>

class Solution {
public:
    int longestIncreasingPath(std::vector<std::vector<int>>& matrix) {
        if (matrix.empty()) return 0;
        int m = matrix.size();
        int n = matrix[0].size();
        std::vector<std::vector<int>> memo(m, std::vector<int>(n, 0));
        int maxPath = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                maxPath = std::max(maxPath, dfs(matrix, i, j, m, n, memo));
            }
        }

        return maxPath;
    }

private:
    int dfs(std::vector<std::vector<int>>& matrix, int i, int j, int m, int n, std::vector<std::vector<int>>& memo) {
        if (memo[i][j] != 0) return memo[i][j];

        int directions[4][2] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int currentMax = 1;

        for (auto& dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[ni][nj] > matrix[i][j]) {
                currentMax = std::max(currentMax, 1 + dfs(matrix, ni, nj, m, n, memo));
            }
        }

        return memo[i][j] = currentMax;
    }
};
```
