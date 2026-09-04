class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int m [] = new int [nums.length];
        for(int i=nums.length-1; i>=0; i--){
            min=Math.min(min,nums[i]);
            m[i]=min;
        }
        for(int i=0; i<nums.length; i++){
            max=Math.max(max,nums[i]);
            if((max-m[i])<=k)
               return i;
        }
        return -1;
    }
}