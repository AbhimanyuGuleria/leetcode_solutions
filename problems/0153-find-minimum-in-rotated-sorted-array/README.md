# 153. [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `43.9 MB`
- **Solved Date:** July 09, 2026 (05:52 UTC)

---

## 💻 Solution
```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right - left)/2;

            if(nums[mid] > nums[right] ){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
```
