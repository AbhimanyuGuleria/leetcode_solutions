# 424. [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/longest-repeating-character-replacement/](https://leetcode.com/problems/longest-repeating-character-replacement/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `27 ms`
- **Memory:** `47 MB`
- **Solved Date:** June 19, 2026 (06:07 UTC)

---

## 💻 Solution
```java
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int longest = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while((right - left + 1) - maxFreq > k ){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            longest = Math.max(longest, (right - left + 1));
        }
        return longest;
    }
}
```
