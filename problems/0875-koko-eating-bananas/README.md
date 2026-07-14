# 875. [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/koko-eating-bananas/](https://leetcode.com/problems/koko-eating-bananas/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `24 ms`
- **Memory:** `48.6 MB`
- **Solved Date:** July 14, 2026 (06:40 UTC)

---

## 💻 Solution
```java
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }

        while(left<=right){
            int mid = left + (right - left)/2;
            long hours = 0;

            for(int pile : piles){
                hours += (int)Math.ceil((double)pile/mid);
            }
            if(hours <= h){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
```
