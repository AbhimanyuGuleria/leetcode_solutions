# 1. [Two Sum](https://leetcode.com/problems/two-sum/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/two-sum/](https://leetcode.com/problems/two-sum/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `47.4 MB`
- **Solved Date:** June 08, 2026 (06:40 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); //value:index
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            int rem = target - num;
             if(map.containsKey(rem)){
                return new int[]{i, map.get(rem)};
             }
             map.put(num, i);
        }
        return new int[]{};
}
}
```
