# 94. [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/binary-tree-inorder-traversal/](https://leetcode.com/problems/binary-tree-inorder-traversal/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `0 ms`
- **Memory:** `43.3 MB`
- **Solved Date:** April 26, 2026 (08:27 UTC)

---

## 💻 Solution
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }

        return result;
    }
}
```
