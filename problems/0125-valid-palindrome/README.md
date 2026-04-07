# 125. [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/valid-palindrome/](https://leetcode.com/problems/valid-palindrome/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `2 ms`
- **Memory:** `44.1 MB`
- **Solved Date:** April 07, 2026 (17:58 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            while (left < right && ! Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while (left < right && ! Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```
