class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        java.util.Map<Integer, Integer> countMap = new java.util.HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        
        java.util.List<Integer>[] buckets = new java.util.List[nums.length + 1];
        
        for (int key : countMap.keySet()) {
            int frequency = countMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new java.util.ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size() && index < k; j++) {
                    result[index] = buckets[i].get(j);
                    index++;
                }
            }
        }
        
        return result;
    }
}