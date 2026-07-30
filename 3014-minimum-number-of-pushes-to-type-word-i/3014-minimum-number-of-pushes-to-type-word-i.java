class Solution {
    public int minimumPushes(String word) {
        int a =0;
        for(int i=0; i<word.length();i++){
            a += (i/8)+1;
        }
        return a;
    }
}