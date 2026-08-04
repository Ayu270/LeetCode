class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> m = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1, p = nums[0]; i < nums.length; i++) {
            while (nums[i] != p + 1) {
                m.add(++p);
            }
            p = nums[i];
        }
        return m;
    }
}