class Solution {
    public List<String> summaryRanges(int[] nums) {
        List <String> n = new ArrayList<>();
        if (nums.length == 0) {
            return n;
        }
        int start = nums[0];
        for(int i=0; i<nums.length; i++){
            if(i==nums.length-1){
                int end = nums[i];
                if(start==end)
                  n.add(start+"");
                else 
                  n.add(start+"->"+end);
            }             
            else {
              if(nums[i]+1 != nums[i+1]){
                int end = nums[i];
                if(start==end)
                  n.add(start+"");
                else 
                  n.add(start+"->"+end);
                start=nums[i+1];
              }
            }
        }
        return n;
    }
}