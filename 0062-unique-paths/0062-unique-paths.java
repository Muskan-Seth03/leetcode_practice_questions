// memoization
class Solution {
    public int solve(int i, int j, int m, int n, int[][] dp)
    {
        // base case
        if(i == m-1 && j == n-1)
        return 1;

        // check boundary
        if(i<0 || i >= m || j<0 || j >= n)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int right = solve(i, j+1, m, n, dp);
        int down = solve(i+1, j, m, n, dp);

        return dp[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] d: dp)
        {
            Arrays.fill(d, -1);
        }
        return solve(0, 0, m, n, dp);
    }
}