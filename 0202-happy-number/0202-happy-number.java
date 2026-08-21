class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n !=1 && !seen.contains(n)){
            seen.add(n);
            int s =0;
            while(n!=0){
                int l= n%10;
                s=s+(l*l);
                n=n/10;
            }
            n=s;
        }
        return n==1;
    }
}


// class Solution {
//     public boolean isHappy(int n) {
//         if(n==1)
//           return true;
//         while(n!=1 && n!=4){  //4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
//             int n1 =n;
//             n=0;
//             while(n1!=0){
//                 int l = n1%10;
//                 n1 = n1/10;
//                 n=n+(l*l);
//             }
//             if(n==1)
//               return true;
//         }
//         return false;
//     }
// }