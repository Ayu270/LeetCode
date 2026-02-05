
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] r = new int[n];
        for(int i = 0; i < n; i ++){
            r[i] = nums[((i+nums[i])%n +n)%n];
        }
        return r;
    }
}