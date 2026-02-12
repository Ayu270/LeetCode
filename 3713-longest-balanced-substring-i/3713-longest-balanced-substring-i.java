class Solution {
    public int longestBalanced(String s) {
        int[] freq = new int[26];
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);
                freq[ch - 'a']++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

            Arrays.fill(freq, 0);
        }
        return maxLen;
    }

    private boolean isBalanced(int[] freq) {
        int val = 0;
        for (int i = 0; i < 26; i++) {
            if (val == 0 && freq[i] != 0) {
                val = freq[i];
            } else if (freq[i] != 0 && val != freq[i]) {
                return false;
            }
        }
        return true;
    }
}