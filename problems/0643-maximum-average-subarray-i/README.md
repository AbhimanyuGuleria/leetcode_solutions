# 643. [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/maximum-average-subarray-i/](https://leetcode.com/problems/maximum-average-subarray-i/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `69.8 MB`
- **Solved Date:** April 08, 2026 (18:22 UTC)

---

## 💻 Solution
```java
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        for (int i = 0; i<k; i++){
            currentSum += nums[i];
        }
        int maxSum = currentSum;
        for(int i = k; i < nums.length; i++){
            currentSum = currentSum + nums[i] - nums[i-k];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return (double) maxSum / k;
    }
}
```
