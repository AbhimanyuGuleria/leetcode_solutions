# 76. [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/minimum-window-substring/](https://leetcode.com/problems/minimum-window-substring/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `11.2 MB`
- **Solved Date:** April 21, 2026 (17:43 UTC)

---

## 💻 Solution
```cpp
#include <string>
#include <vector>
#include <climits>

class Solution {
public:
    std::string minWindow(std::string s, std::string t) {
        std::vector<int> map(128, 0);
        for (char c : t) map[c]++;

        int counter = t.size();
        int begin = 0, end = 0, head = 0;
        int d = INT_MAX;

        while (end < s.size()) {
            if (map[s[end++]]-- > 0) counter--;

            while (counter == 0) {
                if (end - begin < d) {
                    head = begin;
                    d = end - head;
                }
                if (map[s[begin++]]++ == 0) counter++;
            }
        }

        return d == INT_MAX ? "" : s.substr(head, d);
    }
};
```
