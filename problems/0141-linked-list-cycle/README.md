# 141. [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/linked-list-cycle/](https://leetcode.com/problems/linked-list-cycle/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `46.5 MB`
- **Solved Date:** July 27, 2026 (12:47 UTC)

---

## 💻 Solution
```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
     if(head == null || head.next == null){
        return false;
     }   
     ListNode slow = head;
     ListNode fast = head;

     while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;

        if(fast == slow){
            return true;
        }
     }
     return false;
    }
}
```
