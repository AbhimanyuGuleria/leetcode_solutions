class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(mapA.containsKey(c)){
                mapA.put(c, mapA.get(c)+1);
            }else{
                mapA.put(c, 1);
            }
        }
         for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            if(mapB.containsKey(c)){
                mapB.put(c, mapB.get(c)+1);
            }else{
                mapB.put(c, 1);
            }
        }
        if(mapA.equals(mapB)){
            return true;
        }else{
            return false;
        }
    }
}