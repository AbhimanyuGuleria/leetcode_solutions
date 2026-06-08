# 217. [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/contains-duplicate/](https://leetcode.com/problems/contains-duplicate/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `16 ms`
- **Memory:** `97.6 MB`
- **Solved Date:** June 08, 2026 (08:23 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                return true;
            }
            map.put(num, i);
        }
        return false;
    }
}
```
