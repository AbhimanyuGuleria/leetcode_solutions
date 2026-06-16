# 11. [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/container-with-most-water/](https://leetcode.com/problems/container-with-most-water/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `4 ms`
- **Memory:** `77.3 MB`
- **Solved Date:** June 16, 2026 (11:04 UTC)

---

## 💻 Solution
```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea  = 0;

        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            if(area > maxArea){
                maxArea = area;
            }

            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }
}
```
