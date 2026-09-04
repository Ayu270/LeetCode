class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        int can = 0;
        int c=0;
        for(int i=0; i<nums.length; i++){
            if(c==0)
             can=nums[i];
            if(nums[i]==can)
              c++;
            else
              c--;
        }
        return can;
        // HashMap <Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        // }
        // for(Map.Entry<Integer, Integer> entry: map.entrySet()){
        //     if(nums.length/2 < entry.getValue())
        //       return entry.getKey();
        // }
        // return 0;
    }
}