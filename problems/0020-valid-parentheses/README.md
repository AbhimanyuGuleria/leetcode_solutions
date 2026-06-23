# 20. [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/valid-parentheses/](https://leetcode.com/problems/valid-parentheses/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `5 ms`
- **Memory:** `43.4 MB`
- **Solved Date:** June 23, 2026 (10:12 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char current = s.charAt(i);
            if(current == '(' || current == '[' || current == '{'){
                stack.push(current);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(top == '(' && current != ')'){
                    return false;
                }
                if(top == '[' && current != ']'){
                    return false;
                }
                if(top == '{' && current != '}'){
                    return false;
                }

            }

        }
        return stack.isEmpty();

    }
}
```
