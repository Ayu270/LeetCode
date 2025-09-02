class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int pg = 0;   
        int cg = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cg++;
            } else {
                result += Math.min(pg, cg);
                pg = cg;
                cg = 1;
            }
        }
        result += Math.min(pg, cg);
        return result;
    }
}