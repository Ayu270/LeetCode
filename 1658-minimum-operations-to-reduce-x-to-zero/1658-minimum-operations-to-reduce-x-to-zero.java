class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0 ; i < n ; ++i){
            sum += nums[i];
        }
        int target = sum - x;
        int left = 0;
        int s = 0;
        int size = -1;
        for(int right = 0 ; right < n ; ++right){
            s += nums[right];
            while(left <= right && s > target){
                s -= nums[left++]; 
            }
            if(s == target){
                size = Math.max(size,right - left +1);
            }
        }
        return size != -1 ?  n - size : -1;
    }
}