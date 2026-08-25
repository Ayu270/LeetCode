class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet <Integer> n = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]%k == 0){
                n.add(nums[i]);
            }
        }
        int a = k;
        while(n.contains(a)){
            a = a+k;
        }
        return a;
    }
}