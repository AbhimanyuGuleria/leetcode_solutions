# 127. [Word Ladder](https://leetcode.com/problems/word-ladder/)

## 📌 Problem Information
- **Difficulty:** 🔴 Hard
- **LeetCode Link:** [https://leetcode.com/problems/word-ladder/](https://leetcode.com/problems/word-ladder/)

## ⚡ Submission Stats
- **Language:** `C++`
- **Runtime:** `41 ms`
- **Memory:** `19.6 MB`
- **Solved Date:** April 21, 2026 (17:33 UTC)

---

## 💻 Solution
```cpp
#include <vector>
#include <string>
#include <unordered_set>
#include <queue>

class Solution {
public:
    int ladderLength(std::string beginWord, std::string endWord, std::vector<std::string>& wordList) {
        std::unordered_set<std::string> dict(wordList.begin(), wordList.end());
        if (dict.find(endWord) == dict.end()) return 0;

        std::queue<std::string> q;
        q.push(beginWord);

        int level = 1;

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                std::string word = q.front();
                q.pop();

                if (word == endWord) return level;

                for (int j = 0; j < word.length(); ++j) {
                    char original = word[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[j] = c;
                        if (dict.count(word)) {
                            q.push(word);
                            dict.erase(word);
                        }
                    }
                    word[j] = original;
                }
            }
            level++;
        }

        return 0;
    }
};
```
