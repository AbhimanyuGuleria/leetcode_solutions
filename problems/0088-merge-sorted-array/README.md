# 88. [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/merge-sorted-array/](https://leetcode.com/problems/merge-sorted-array/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `43.7 MB`
- **Solved Date:** July 23, 2026 (14:41 UTC)

---

## 💻 Solution
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;          // Last valid element in nums1
        int j = n - 1;          // Last element in nums2
        int k = m + n - 1;      // Last index of nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // Copy remaining elements from nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
```
