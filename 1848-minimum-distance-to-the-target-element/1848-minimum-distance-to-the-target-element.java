class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int m = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(target == nums[i]){
                m= Math.min(m,Math.abs(i-start));
            }
        }
        return m;
    }
}