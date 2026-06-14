# 15. [3Sum](https://leetcode.com/problems/3sum/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/3sum/](https://leetcode.com/problems/3sum/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `29 ms`
- **Memory:** `59 MB`
- **Solved Date:** June 14, 2026 (08:15 UTC)

---

## 💻 Solution
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i < nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
        while(left < right){
            int sum = nums[i] + nums[left] + nums[right];
            if(sum < 0){
                left++;
            }else if(sum>0){
                right--;
            }else{
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                left++;
                right--;
                while(left <right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left < right && nums[right] == nums[right+1]){
                    right--;
                }
            }
        }
        }
        return result;
    }
}
```
