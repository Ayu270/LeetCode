class Solution {
    public int minimumDeletions(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        Arrays.sort(nums);
        int minIndex = map.get(nums[0]);
        int maxIndex = map.get(nums[nums.length - 1]);
        int left = Math.max(minIndex, maxIndex) + 1;
        int right = nums.length - Math.min(minIndex, maxIndex);
        int fromBothSides = Math.min(minIndex + 1 + (nums.length - maxIndex), maxIndex + 1 + (nums.length - minIndex));
        
        return Math.min(fromBothSides,Math.min(left, right));
    }
}