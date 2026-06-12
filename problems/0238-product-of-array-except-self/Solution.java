class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for(int i = 1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        int[] ans = new int[nums.length];
        ans[nums.length - 1] = 1;
        for(int i = nums.length - 2; i>=0; i--){
            ans[i] = ans[i+1] * nums[i+1];
        }
        for(int i = 0; i<nums.length; i++){
             ans[i]*=left[i];
        }
        return ans;
    }
}