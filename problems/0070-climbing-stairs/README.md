# 70. [Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/climbing-stairs/](https://leetcode.com/problems/climbing-stairs/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `41.6 MB`
- **Solved Date:** April 19, 2026 (16:37 UTC)

---

## 💻 Solution
```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int first = 1;
        int second = 2;
        
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}
```
