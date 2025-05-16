class Solution {   // TC:O(n^2) SC:O(1)
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        int start = 0;
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            // Even length palindrome
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }

            // Odd length palindrome
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    start = l;
                }
                l--;
                r++;
            }
        }

        return s.substring(start, start + maxLen);
    }
}
