# 110. [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/balanced-binary-tree/](https://leetcode.com/problems/balanced-binary-tree/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `45.5 MB`
- **Solved Date:** August 03, 2026 (08:06 UTC)

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
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = height(root.left);
        if(left == -1){
            return -1;
        }
        int right = height(root.right);

        
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Math.max(left,right);
    }
}
```
