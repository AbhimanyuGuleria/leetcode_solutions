# 125. [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/valid-palindrome/](https://leetcode.com/problems/valid-palindrome/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `44.2 MB`
- **Solved Date:** June 14, 2026 (06:56 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
}
```
