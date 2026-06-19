# 3. [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/longest-substring-without-repeating-characters/](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `6 ms`
- **Memory:** `46.3 MB`
- **Solved Date:** June 19, 2026 (05:24 UTC)

---

## 💻 Solution
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int longest = 0;

        for(int right = 0; right<s.length(); right++){
            char window = s.charAt(right);

            while(set.contains(window)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(window);
            longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }
}
```
