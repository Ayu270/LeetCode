class Solution {
    public String smallestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }          
        int n = s.length();
        int m = n/2;
        char[] a = s.toCharArray();
        Arrays.sort(a,0,m);
        for(int i=0; i<m; i++){
            a[n-1-i]=a[i];
        }
        return new String(a);
    }
}