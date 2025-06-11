class Solution {  // tabulation approach  TC: O(n*m)  SC: O(n*m)
    public boolean isMatch(String s, String p) {
        int n= s.length();
        int m= p.length();
        int [][] dp= new int [n+1][m+1]; 

        //base case
        dp[0][0]= 1;

        for(int i=1; i<=n; i++)
        dp[i][0]= 0;

        for(int j=1; j<=m; j++)
        {
            int flag= 1;
            for(int ii= 1; ii<=j; ii++)
            {
                if(p.charAt(ii-1) != '*')
                {
                    flag= 0;
                    break;
                }
            }
            dp[0][j]= flag;   
        }
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) =='?')
                dp[i][j]= dp[i-1][j-1];
                else if(p.charAt(j-1) =='*')
                dp[i][j]= (dp[i-1][j] ==1 || dp[i][j-1] ==1) ? 1 : 0;
                else
                dp[i][j]=0;
            }
        }
        if(dp[n][m] > 0)
        return true;
        else
        return false;
    }
}