class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap <Integer, Integer> freq = new HashMap <>();
        for(int i=0; i<nums.length; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        if(k==1){
            int l1 =0;
            for(int i=0; i<nums.length; i++){
                if(freq.get(nums[i])==1)
                   l1 = Math.max(l1,nums[i]);
            }
            if(freq.get(nums[0])==nums.length)
               l1=-1;
            return l1;
        } else if (k == nums.length){
            int l =0;
            for(int i=0; i<nums.length; i++){
                l = Math.max(l,nums[i]);
            }
            return l;
        } else {
            if(freq.get(nums[0])==1 && freq.get(nums[nums.length-1])==1){
                return Math.max(nums[0],nums[nums.length-1]);
            } else if (freq.get(nums[0])>1 && freq.get(nums[nums.length-1])>1){
                return -1;
            } else if (freq.get(nums[0])>freq.get(nums[nums.length-1])){
                return nums[nums.length-1];
            } else {
                return nums[0];
            }
        }
    }
}