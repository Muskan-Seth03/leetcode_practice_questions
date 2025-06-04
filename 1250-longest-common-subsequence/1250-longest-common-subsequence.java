class Solution {  // tabulation approach   TC:O(n*m)  SC:O(n*m)
    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        int dp[][]= new int[n+1][m+1];
        //base case
        
        dp[n][m]=0;

        for(int i=n-1; i>=0; i--)
        {
            for(int j= m-1; j>=0; j--)
            {

                if(text1.charAt(i) == text2.charAt(j))   // if match found
                dp[i][j] = 1 + dp[i + 1][j + 1];

                else
                dp[i][j] = 0 + Math.max(dp[i +1][j], dp[i][j + 1]);       
            }
        }
        return dp[0][0];
    }
}