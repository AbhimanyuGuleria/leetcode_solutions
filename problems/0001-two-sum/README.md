# 1. [Two Sum](https://leetcode.com/problems/two-sum/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `47.1 MB`
- **Solved Date:** May 01, 2026 (11:06 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
```
