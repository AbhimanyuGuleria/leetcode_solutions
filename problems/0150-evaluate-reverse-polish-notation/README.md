# 150. [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/evaluate-reverse-polish-notation/](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `7 ms`
- **Memory:** `45.5 MB`
- **Solved Date:** June 25, 2026 (10:57 UTC)

---

## 💻 Solution
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int first = stack.pop();
                int second = stack.pop();

                if(token.equals("+")){
                    stack.push(second + first);
                }else if(token.equals("-")){
                    stack.push(second - first);
                }else if(token.equals("*")){
                    stack.push(second * first);
                }else if(token.equals("/")){
                    stack.push(second / first);
                }
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
```
