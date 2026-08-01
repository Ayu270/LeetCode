// class Solution {
//     public boolean predictTheWinner(int[] nums) {
//         int n = nums.length;
//         int p1 =0;
//         int p2=0;
//         ArrayList<Integer> list = new ArrayList<>();
//         for(int i=0; i<n; i++){
//             list.add(nums[i]);
//         }
//         int c1=0;
//         int c2=1;
//         while (!list.isEmpty()){
//             if(c1==0){
//                 if(list.get(0)>= list.get(list.size()-1)){
//                     p1=p1+list.get(0);
//                     list.remove(0);
//                 } else {
//                     p1=p1+list.get(list.size()-1);
//                     list.remove(list.size()-1);
//                 }
//                 c1=1;
//                 c2=0;
//             } else {
//                 if(list.get(0)>= list.get(list.size()-1)){
//                     p2=p2+list.get(0);
//                     list.remove(0);
//                 } else {
//                     p2=p2+list.get(list.size()-1);
//                     list.remove(list.size()-1);
//                 }                
//                 c2=1;
//                 c1=0;
//             }
//         }
//         if(p1>=p2)
//            return true;
//         else
//            return false;
//     }
// }

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(
                    nums[i] - dp[i + 1][j],
                    nums[j] - dp[i][j - 1]
                );
            }
        }
        return dp[0][n - 1] >= 0;
    }
}