class Solution {
    public int minimumDeletions(String s) {
        int a = 0, b = 0;
        for (char c : s.toCharArray()) {
            if (c == 'b') b++;
            else if (b > 0) {
                a++;
                b--;
            }
        }
        return a;
    }
}