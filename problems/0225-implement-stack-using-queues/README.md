# 225. [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/implement-stack-using-queues/](https://leetcode.com/problems/implement-stack-using-queues/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `0 ms`
- **Memory:** `9.6 MB`
- **Solved Date:** October 29, 2025 (17:09 UTC)

---

## 💻 Solution
```cpp
class MyStack {
    std::queue<int> q1, q2;
public:
    MyStack() {
        
    }
    
    void push(int x) {
        q2.push(x);
        while (!q1.empty()) {
            q2.push(q1.front());
            q1.pop();
        }
        std::swap(q1, q2);

    }
    
    int pop() {
        int ret = q1.front();
        q1.pop();
        return ret;
    }
    
    int top() {
                return q1.front();

    }
    
    bool empty() {
                return q1.empty();

    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */
```
