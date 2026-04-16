# 703. [Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/kth-largest-element-in-a-stream/](https://leetcode.com/problems/kth-largest-element-in-a-stream/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `23 ms`
- **Memory:** `52.2 MB`
- **Solved Date:** April 16, 2026 (05:43 UTC)

---

## 💻 Solution
```java
class KthLargest {
    
    private int k;
    private java.util.PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new java.util.PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
```
