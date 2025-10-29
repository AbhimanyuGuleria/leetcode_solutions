# 20. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `8.8 MB`
- **Solved Date:** October 29, 2025 (17:05 UTC)

---

## 💻 Solution
```cpp
class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for (char c : s) {
            // Push opening brackets to stack
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                // If closing bracket and stack is empty, string is invalid
                if (st.empty()) return false;
                // Check for matching opening bracket
                if ((c == ')' && st.top() != '(') ||
                    (c == ']' && st.top() != '[') ||
                    (c == '}' && st.top() != '{'))
                    return false;
                st.pop();
            }
        }
        // If stack is empty, all brackets matched correctly
        return st.empty();
    }
};
```
