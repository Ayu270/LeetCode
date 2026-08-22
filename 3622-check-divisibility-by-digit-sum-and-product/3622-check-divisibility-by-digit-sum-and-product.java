class Solution {
    public boolean checkDivisibility(int n) {
        int n1=n;
        int s=0;
        int p=1;
        while(n1!=0){
            int d = n1%10;
            n1=n1/10;
            s=s+d;
            p=p*d;
        }
        return n % (s+p) == 0;
    }
}