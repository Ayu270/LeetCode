class Solution {
    public int[] countBits(int n) {
        int r [] = new int [n+1];
        for(int i=0; i<=n; i++){ 
            int j=i;
            int c=0;
            while(j!=0){
                j=j&(j-1);
                c++;
            }
            r[i]=c;
        }
        return r;
    }
}