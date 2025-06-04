class Solution {  // memoization approach   TC:O(m*n)  SC:O(N*M) + O(N+M)
    public int f(String text1, String text2, int ind1, int ind2, int dp[][])
    {
        int n= text1.length();
        int m= text2.length();
        if(ind1 >=n || ind2 >=m)
        return 0;

        if(dp[ind1][ind2] !=-1)
        return dp[ind1][ind2];

        if(text1.charAt(ind1) == text2.charAt(ind2))   // if match found
        return dp[ind1][ind2] = 1 + f(text1, text2, ind1 + 1, ind2 + 1, dp);

        else
        return dp[ind1][ind2] = 0 + Math.max(f(text1, text2, ind1 +1, ind2, dp), f(text1, text2, ind1, ind2 + 1, dp)); 

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n= text1.length();
        int m= text2.length();
        int dp[][]= new int[n][m];
        
        for(int row[]: dp)
        Arrays.fill(row, -1);

        return f(text1, text2, 0, 0, dp);

    }
}