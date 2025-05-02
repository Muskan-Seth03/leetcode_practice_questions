// TC: O(n^2) + O(n)   lcs + StringBuilder
// SC: O(n*n)
class Solution {  // using dp + lcs approach  
    public int longestCommonSubsequence(String s, String rev) {
        int n= s.length();
        // Create a 2D DP array
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match, take left diagonal + 1
                if (s.charAt(i - 1) == rev.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }

    public int longestPalindromeSubseq(String s){
        int n = s.length();

        // use StringBuilder method to reverse the given string s
        String rev= new StringBuilder(s).reverse().toString();   // O(n)

        return longestCommonSubsequence(s, rev);
    }
}
