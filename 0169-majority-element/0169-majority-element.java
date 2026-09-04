class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(nums.length/2 < entry.getValue())
              return entry.getKey();
        }
        return 0;
    }
}