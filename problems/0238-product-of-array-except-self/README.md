# 238. [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/product-of-array-except-self/](https://leetcode.com/problems/product-of-array-except-self/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `72.2 MB`
- **Solved Date:** June 12, 2026 (07:37 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i <nums.length; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        int rightProduct = 1;
        for(int i = nums.length -1; i >= 0; i--){
            ans[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return ans;
    }
}
```
