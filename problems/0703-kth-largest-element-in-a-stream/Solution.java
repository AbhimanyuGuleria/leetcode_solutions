class KthLargest {
    
    private int k;
    private java.util.PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new java.util.PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */