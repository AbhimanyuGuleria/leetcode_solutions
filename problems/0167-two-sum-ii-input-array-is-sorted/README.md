# 167. [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `48.2 MB`
- **Solved Date:** June 14, 2026 (07:33 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] < target){
                left++;
            }else if(numbers[left] + numbers[right] > target){
                right--;
            }else{
                return new int[]{left+1, right+1};
            }
        }
        return new int[]{};
    }
}
```
