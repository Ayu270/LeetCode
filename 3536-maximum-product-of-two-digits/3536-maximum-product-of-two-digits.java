class Solution {
    public int maxProduct(int n) {
        String s = String.valueOf(n);
        int a [] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
           a[i] = s.charAt(i) - '0';
        }
        Arrays.sort(a);
        return (a[a.length-1]*a[a.length-2]);
    }
}