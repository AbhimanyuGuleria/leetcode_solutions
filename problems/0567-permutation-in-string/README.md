# 567. [Permutation in String](https://leetcode.com/problems/permutation-in-string/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/permutation-in-string/](https://leetcode.com/problems/permutation-in-string/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `7 ms`
- **Memory:** `44.1 MB`
- **Solved Date:** June 20, 2026 (08:03 UTC)

---

## 💻 Solution
```java
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] s1Count = new int[26];
        int [] windowCount = new int[26];
       
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i = 0; i<s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s1.length(); i++){
            windowCount[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(s1Count, windowCount)){
            return true;
        }
            for(int right = s1.length(); right < s2.length(); right++){
                windowCount[s2.charAt(right) - 'a']++;
                windowCount[s2.charAt(right - s1.length()) - 'a']--;

                if(Arrays.equals(s1Count, windowCount)){
                return true;
                }
            }
        
    return false;
    }
}
```
