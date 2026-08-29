class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        // for(int i=0; i<nums.length; i++){
        //     m=m^nums[i];
        // }
        // return m;
        int m=0;
        HashMap <Integer, Integer> ma = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            ma.put(nums[i], ma.getOrDefault(nums[i],0)+1);
            // m=m^nums[i];
        }
        // if(m>0)
        //   return m;
        for(Map.Entry<Integer,Integer> entry: ma.entrySet()){
            if(entry.getValue()>=2){
                m=m^entry.getKey();
            }
        }
        return m;

    }
}