class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s = n*(n+1)/2;
        int s1 = 0;
        for(int i=0; i<n; i++){
            s1+=nums[i];
        }
        return s-s1;
        // int n = nums.length;
        // Arrays.sort(nums);
        // int c= 0;
        // for(int i=0; i<n; i++){
        //     if(nums[i]!=c)
        //       return c;
        //     c++;
        // }
        // return c;

    }
}