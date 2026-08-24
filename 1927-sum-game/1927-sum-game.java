class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int left = 0;
        int right = 0;
        int leftQ = 0;
        int rightQ = 0;
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                leftQ++;
            } else {
                left += num.charAt(i) - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                rightQ++;
            } else {
                right += num.charAt(i) - '0';
            }
        }
        int diff = left - right;
        int qDiff = leftQ - rightQ;
        if (qDiff % 2 != 0) {
            return true;
        }

        return diff != -9 * qDiff / 2;
    }
}