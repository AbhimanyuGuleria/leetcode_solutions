# 53. [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/maximum-subarray/](https://leetcode.com/problems/maximum-subarray/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `1 ms`
- **Memory:** `76.9 MB`
- **Solved Date:** April 10, 2026 (16:16 UTC)

---

## 💻 Solution
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(currentSum < 0){
                currentSum = nums[i];
            }else{
                currentSum = currentSum + nums[i];
            }
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
```
