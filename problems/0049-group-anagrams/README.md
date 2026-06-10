# 49. [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `7 ms`
- **Memory:** `49.4 MB`
- **Solved Date:** June 10, 2026 (06:53 UTC)

---

## 💻 Solution
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);            
        }
        return new ArrayList<>(map.values());
    }
}
```
