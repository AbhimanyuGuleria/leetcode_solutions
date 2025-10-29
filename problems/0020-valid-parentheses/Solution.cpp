class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for (char c : s) {
            // Push opening brackets to stack
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                // If closing bracket and stack is empty, string is invalid
                if (st.empty()) return false;
                // Check for matching opening bracket
                if ((c == ')' && st.top() != '(') ||
                    (c == ']' && st.top() != '[') ||
                    (c == '}' && st.top() != '{'))
                    return false;
                st.pop();
            }
        }
        // If stack is empty, all brackets matched correctly
        return st.empty();
    }
};