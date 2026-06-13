# 36. [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/valid-sudoku/](https://leetcode.com/problems/valid-sudoku/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `8 ms`
- **Memory:** `46.8 MB`
- **Solved Date:** June 13, 2026 (06:21 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int row = 0; row<9; row++){
            for(int col = 0; col <9; col++){
                if(board[row][col] == '.'){
                    continue;
                }

                char num = board[row][col];

                int box = (row/3)*3 + (col/3);

                String rowKey = num + "row" + row;
                String colKey = num + "col" + col;
                String boxKey = num + "box" + box;

                if(set.contains(rowKey) || set.contains(colKey) || set.contains(boxKey)){
                    return false;
                }
                set.add(rowKey);
                set.add(colKey);
                set.add(boxKey);
            }
        }
        return true;
    }
}
```
