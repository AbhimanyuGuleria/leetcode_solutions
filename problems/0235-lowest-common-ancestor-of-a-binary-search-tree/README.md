# 235. [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `6 ms`
- **Memory:** `47.9 MB`
- **Solved Date:** August 08, 2026 (09:01 UTC)

---

## 💻 Solution
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        
        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        
        return null;
    }
}
```
