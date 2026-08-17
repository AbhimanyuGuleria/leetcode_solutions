# 124. [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/binary-tree-maximum-path-sum/](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `46.6 MB`
- **Solved Date:** August 17, 2026 (16:14 UTC)

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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftGain = maxGain(root.left);
        int rightGain = maxGain(root.right);

        leftGain = Math.max(0, leftGain);
        rightGain = Math.max(0, rightGain);

        int currentPath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}
```
