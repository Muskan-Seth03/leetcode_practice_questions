// memoization approach
// TC: (m * n) SC: O(m * n)
class Solution {
    int[][] dp;
    public int solve(int i, int j, String s1, String s2)
    {
        // if i and j th char is empty
        if( i>= s1.length() && j>= s2.length())
        return 0;
        
        if(dp[i][j] != -1)
        return dp[i][j];

        // if i or j th char is empty
        if(i >= s1.length())
        {
            return (int) s2.charAt(j) + solve(i, j+1, s1, s2);
        }
        if(j >= s2.length())
        {
            return (int) s1.charAt(i) + solve(i+1, j, s1, s2);
        }

        if(s1.charAt(i) == s2.charAt(j))
        {
            return 0 + solve(i+1, j+1, s1, s2);
        }
        // if non empty and not same , 2 options
        int delete_s1_i= (int) s1.charAt(i) + solve(i+1, j, s1, s2);
        int delete_s2_j= (int) s2.charAt(j) + solve(i, j+1, s1, s2);

        return dp[i][j]= Math.min(delete_s1_i, delete_s2_j);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m= s1.length();
        int n= s2.length();
        dp= new int[1001][1001];

        for(int i=0; i< dp.length; i++)
        Arrays.fill(dp[i], -1);

        return solve(0, 0, s1, s2);
    }
}