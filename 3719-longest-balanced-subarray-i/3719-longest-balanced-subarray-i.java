class Solution {
    int[] A1 = new int[100001];
    int[] A2 = new int[100001];
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int timer = 0;
        for(int i = 0; i < n; i++){
           timer++;
           int even = 0;
           int odd = 0;
           if(maxLen > n-i) break;    
           for(int j = i; j < n; j++){
              int val = nums[j];
              if(val % 2 == 0){
              if(A1[val] != timer){
                 A1[val] = timer;
                 even++;
              }
             }else{
             if(A2[val] != timer){
               A2[val] = timer;
               odd++;
             }
           }
           if(even == odd){
              maxLen = Math.max(maxLen, j-i+1);
            }
          }
        }     
    return maxLen;
    }
}