# 239. [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/sliding-window-maximum/](https://leetcode.com/problems/sliding-window-maximum/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `30 ms`
- **Memory:** `146.3 MB`
- **Solved Date:** June 22, 2026 (06:41 UTC)

---

## 💻 Solution
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];

        int index = 0;

        for(int i = 0; i < nums.length; i++) {

            // Remove indices outside the window
            if(!deque.isEmpty() &&
               deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while(!deque.isEmpty() &&
                  nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store answer once first window is complete
            if(i >= k - 1) {
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
```
