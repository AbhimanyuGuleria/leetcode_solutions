# 142. [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/linked-list-cycle-ii/](https://leetcode.com/problems/linked-list-cycle-ii/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `46.6 MB`
- **Solved Date:** July 28, 2026 (08:48 UTC)

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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                ListNode pointer = head;

                while(pointer != slow){
                    pointer = pointer.next;
                    slow = slow.next;
                }
                return pointer;
            }

        }
        return null;
    }
}
```
