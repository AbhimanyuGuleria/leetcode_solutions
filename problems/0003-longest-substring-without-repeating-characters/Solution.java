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