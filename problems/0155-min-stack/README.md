# 155. [Min Stack](https://leetcode.com/problems/min-stack/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/min-stack/](https://leetcode.com/problems/min-stack/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `4 ms`
- **Memory:** `23.6 MB`
- **Solved Date:** October 29, 2025 (17:11 UTC)

---

## 💻 Solution
```cpp
class MinStack {
public:
    stack<int> s, min_s;

    MinStack() {
        
    }
    
    void push(int val) {
         s.push(val);
        if (min_s.empty() || val <= min_s.top())
            min_s.push(val);
    }
    
    void pop() {
        if (!s.empty()) {
            if (s.top() == min_s.top())
                min_s.pop();
            s.pop();
        }
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
         return min_s.top();
       
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
```
