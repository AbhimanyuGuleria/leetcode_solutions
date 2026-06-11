class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        //create a bucket
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        //place numbers into bucket
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        //collect top k frequent elements
        int[] result = new int[k];
        int index = 0;

        for(int i = bucket.length -1; i>=0 && index < k; i--){
            if(bucket[i] != null){
                for(int j = 0; j < bucket[i].size() && index < k; j++){
                    result[index] = bucket[i].get(j);
                    index++;
                }
            }
        }
        return result;
    }
}