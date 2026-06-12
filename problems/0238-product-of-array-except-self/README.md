# 238. [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/product-of-array-except-self/](https://leetcode.com/problems/product-of-array-except-self/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `3 ms`
- **Memory:** `64.7 MB`
- **Solved Date:** June 12, 2026 (07:06 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            ans[i] = right[i] * left[i];
        }
        return ans;
    }
}
```
