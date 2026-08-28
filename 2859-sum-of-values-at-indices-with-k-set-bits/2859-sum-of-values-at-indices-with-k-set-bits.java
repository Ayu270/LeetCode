class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int s=0;
        for(int i=0; i<nums.size(); i++){
            int n = i;
            int c=0;
            while(n!=0){
                n=n&(n-1);
                c++;
            }
            if(c==k)
              s=s+nums.get(i);
        }
        return s;
    }
}