# 746. [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/min-cost-climbing-stairs/](https://leetcode.com/problems/min-cost-climbing-stairs/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `45 MB`
- **Solved Date:** April 21, 2026 (17:47 UTC)

---

## 💻 Solution
```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0;
        int second = 0;
        
        for (int i = 2; i <= cost.length; i++) {
            int current = Math.min(first + cost[i - 2], second + cost[i - 1]);
            first = second;
            second = current;
        }
        
        return second;
    }
}
```
