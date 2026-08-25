class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int c= 0;
        for(int i=0; i<n; i++){
            if(nums[i]!=c)
              return c;
            c++;
        }
        return c;
    }
}