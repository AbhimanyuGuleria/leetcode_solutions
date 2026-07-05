# 128. [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/longest-consecutive-sequence/](https://leetcode.com/problems/longest-consecutive-sequence/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `31 ms`
- **Memory:** `95.7 MB`
- **Solved Date:** July 05, 2026 (02:34 UTC)

---

## 💻 Solution
```java
class Solution {
    public int longestConsecutive(int[] nums) {
      HashSet<Integer> set = new HashSet<>();
      for(int i = 0; i<nums.length; i++){
        int num = nums[i];
        set.add(num);
      }  
      int longest = 0;
      for(int num : set){
        if(!set.contains(num - 1)){
            int current = num;
            int length = 1;

            while(set.contains(current+1)){
                current++;
                length++;
            }

            longest = Math.max(longest, length);

        }
      }
      return longest;
    } 
}
```
