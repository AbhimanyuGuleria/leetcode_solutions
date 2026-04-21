#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>

class Solution {
public:
    std::vector<std::string> wordBreak(std::string s, std::vector<std::string>& wordDict) {
        std::unordered_set<std::string> dict(wordDict.begin(), wordDict.end());
        std::unordered_map<string, std::vector<std::string>> memo;
        return backtrack(s, dict, memo);
    }

private:
    std::vector<std::string> backtrack(std::string s, std::unordered_set<std::string>& dict, std::unordered_map<string, std::vector<std::string>>& memo) {
        if (memo.count(s)) return memo[s];
        if (s.empty()) return {""};

        std::vector<std::string> res;
        for (int i = 1; i <= s.length(); ++i) {
            std::string word = s.substr(0, i);
            if (dict.count(word)) {
                std::vector<std::string> subRes = backtrack(s.substr(i), dict, memo);
                for (std::string sub : subRes) {
                    res.push_back(word + (sub.empty() ? "" : " ") + sub);
                }
            }
        }

        return memo[s] = res;
    }
};