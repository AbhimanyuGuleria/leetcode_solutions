# 49. [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/group-anagrams/](https://leetcode.com/problems/group-anagrams/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `19 ms`
- **Memory:** `50.5 MB`
- **Solved Date:** June 10, 2026 (07:51 UTC)

---

## 💻 Solution
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i<strs.length; i++){
            String word = strs[i];

            int [] count = new int[26];

            for(int j =0; j<word.length(); j++){
                count[word.charAt(j) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int num : count){
                sb.append('#');
                sb.append(num);
            }

            String key = sb.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
```
