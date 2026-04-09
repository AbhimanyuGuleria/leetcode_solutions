# 724. [Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/find-pivot-index/](https://leetcode.com/problems/find-pivot-index/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `1 ms`
- **Memory:** `47.6 MB`
- **Solved Date:** April 09, 2026 (17:06 UTC)

---

## 💻 Solution
```java
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;

        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        int leftSum = 0;
        for(int i = 0; i<nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
```
