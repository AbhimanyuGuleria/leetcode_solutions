# 739. [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/daily-temperatures/](https://leetcode.com/problems/daily-temperatures/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `60 ms`
- **Memory:** `107.7 MB`
- **Solved Date:** June 28, 2026 (06:58 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answers = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                answers[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return answers;
    }
}
```
