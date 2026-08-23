class Solution {
    public void moveZeroes(int[] nums) {
        int c=0;
        for(int i=0; i<nums.length; i++){
            if(nums.length==1)
              break;
            if(nums[i]!=0){
              nums[c]=nums[i];
              if(i != c)
                nums[i]=0;
              c++;
            }
        }
    }
}