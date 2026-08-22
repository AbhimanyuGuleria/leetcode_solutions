# 297. [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/serialize-and-deserialize-binary-tree/](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `15 ms`
- **Memory:** `47.5 MB`
- **Solved Date:** August 22, 2026 (04:38 UTC)

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        serializeTree(root, list);
        return String.join(",", list);
    }
    private void serializeTree(TreeNode root, List<String> list){
        if(root == null){
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        serializeTree(root.left, list);
        serializeTree(root.right, list);

    }

    // Decodes your encoded data to tree.
    private int index = 0;
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");

        index = 0;
        return buildTree(values);
        
    }
    private TreeNode buildTree(String[] values){
        if(values[index].equals("null")){
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index]));

        index++;

        node.left = buildTree(values);
        node.right = buildTree(values);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
```
