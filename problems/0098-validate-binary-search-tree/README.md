# 98. [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/validate-binary-search-tree/](https://leetcode.com/problems/validate-binary-search-tree/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `45 MB`
- **Solved Date:** April 28, 2026 (12:02 UTC)

---

## 💻 Solution
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        return isValidBST(node.left, min, node.val) && 
               isValidBST(node.right, node.val, max);
    }
}
```
