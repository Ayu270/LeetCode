class Solution {
    public int reverse(int x) {
        int n =0;
        int neg=0;
        // 0-(-123)
        if(x<0){
            x=0-(x);
            neg=1;
        }
        while(x>0){
            int l = x%10;
            if (n > (Integer.MAX_VALUE - l) / 10) {
                return 0;  // Agar overflow hua, toh 0 return kardo
            }
            x = x/10;
            n = n*10+l;
        }
        // 123-(2*123)
        if(neg==1){
            n=n-(2*n);
        }
        return n;       
    }
}