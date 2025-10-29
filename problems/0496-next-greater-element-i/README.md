# 496. [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/next-greater-element-i/](https://leetcode.com/problems/next-greater-element-i/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `4 ms`
- **Memory:** `12.9 MB`
- **Solved Date:** October 29, 2025 (17:13 UTC)

---

## 💻 Solution
```cpp
class Solution {
public:
    vector<int> nextGreaterElement(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> nge; 
        stack<int> st;
        
        for (int num : nums2) {
            while (!st.empty() && st.top() < num) {

                nge[st.top()] = num;
                st.pop();
            }
            st.push(num);
        }
        while (!st.empty()) {
            nge[st.top()] = -1;
            st.pop();
        }
        
        vector<int> result;
        for (int num : nums1) {
            result.push_back(nge[num]);
        }
        return result;
    }
};
```
