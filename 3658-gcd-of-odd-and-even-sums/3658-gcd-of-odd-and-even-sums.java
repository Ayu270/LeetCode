class Solution {
    public int gcdOfOddEvenSums(int n) {
        int c=1;
        int so=1;
        int tso=1;
        int se=2;
        int tse=2;
        while(c<n){
            so=so+2;
            tso=tso+so;
            se=se+2;
            tse=tse+se;
            c++;
        }
        int g=1;
        for(int i=2; i<Math.min(tso,tse)+1; i++){
            if(tso%i == 0 && tse%i==0){
               g=i;
            }
               
        }
        return g;
    }
}