class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int maxWindow = 1;
        for(int right = 0; right < n; right++) {
            while(nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxWindow = Math.max(maxWindow, right-left+1);
        }
        return n - maxWindow;
    }
} 