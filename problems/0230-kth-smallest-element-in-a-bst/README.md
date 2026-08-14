# 230. [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/kth-smallest-element-in-a-bst/](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `46.6 MB`
- **Solved Date:** August 14, 2026 (05:13 UTC)

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
    private int count = 0;
    private int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    private void inorder(TreeNode root, int k){
        if(root == null){
            return;
        }

        inorder(root.left, k);

        count++;

        if(count == k){
            answer = root.val;
        }

        inorder(root.right, k);
    }
}
```
