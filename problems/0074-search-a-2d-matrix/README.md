# 74. [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/search-a-2d-matrix/](https://leetcode.com/problems/search-a-2d-matrix/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `44.1 MB`
- **Solved Date:** July 19, 2026 (05:14 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0; 
        int right = (rows*cols) - 1;

        while(left<=right){
            int mid = left + (right-left)/2;

            int row = mid/cols;
            int col = mid%cols;

            if(matrix[row][col] == target){
                return true;
            }else if(matrix[row][col] < target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
```
