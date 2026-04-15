class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return result;
    }
}