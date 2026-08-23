class Solution {
    public void reverseString(char[] s) {
        int l= s.length-1;
        for(int i=0; i<s.length/2; i++){
            char temp = s[l];
            s[l]= s[i];
            s[i]=temp;
            l--;
        }
    }
}