class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> targetMap = new HashMap<>();

        for(int i = 0; i <t.length(); i++){
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int have = 0;
        int need = targetMap.size();
        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right<s.length();right++){
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if(targetMap.containsKey(c) && windowMap.get(c).equals(targetMap.get(c))){
                have++;
            }
            while(have == need){
                if((right-left+1) < minLength){
                    minLength = right-left+1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                if(targetMap.containsKey(leftChar) && windowMap.get(leftChar) < targetMap.get(leftChar)){
                    have--;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start+minLength);
    }
}