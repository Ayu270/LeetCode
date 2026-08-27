class Solution {
    public void sortColors(int[] nums) {
        HashMap <Integer, Integer> n = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            n.put(nums[i], n.getOrDefault(nums[i],0)+1);
        }
        int c=0;
        for(int i=0; i<nums.length;){
            if(n.containsKey(c)){
            if(n.get(c)>0){
                nums[i]=c;
                i++;
                int t=n.get(c)-1;
                n.put(c,t);
            } else {
                c++;
            } 
            } else {
                c++;
            }
        }
    }
}