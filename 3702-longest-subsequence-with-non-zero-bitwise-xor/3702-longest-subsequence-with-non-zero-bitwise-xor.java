class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int nz=0;
        int j=0;
        for(int i=0; i<n; i++){
            j ^= nums[i];
            if(nums[i] != 0)
              nz++;
        }
        if(j != 0)
           return n;
        if(nz == 0)
           return 0;
        return n-1;
    }
}