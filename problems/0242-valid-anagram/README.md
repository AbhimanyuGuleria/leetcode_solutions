# 242. [Valid Anagram](https://leetcode.com/problems/valid-anagram/)

## 📌 Problem Information
- **Difficulty:** 🟢 Easy
- **LeetCode Link:** [https://leetcode.com/problems/valid-anagram/](https://leetcode.com/problems/valid-anagram/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `5 ms`
- **Memory:** `44.3 MB`
- **Solved Date:** June 09, 2026 (06:59 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean isAnagram(String s, String t) {
       int [] count = new int[26];
       if(s.length() != t.length()){
        return false;
       }
       for(int i = 0;i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
       }
       for(int v : count){
        if(v!=0){
            return false;
        }
       }
       return true;
    }
}
```
