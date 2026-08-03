class Solution {
    public int solve(int i, int j, int[] piles, int[][] dp)
    {   
        int n = piles.length;
        // base case
        if(i == j)
        return piles[i];

        if(i > j || i>=n || j<0)
        return 0;

        if(dp[i][j] != -1)
        return dp[i][j];

        int take_i = piles[i] + Math.min(solve(i+2, j, piles, dp), solve(i+1, j-1, piles, dp));

        int take_j = piles[j] + Math.min(solve(i+1, j-1, piles, dp), solve(i, j-2, piles, dp));

        return dp[i][j] = Math.max(take_i, take_j);       
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int pile : piles)
        {
            total += pile;
        }
        int[][] dp = new int[n][n];

        for(int[] d : dp)
        Arrays.fill(d, -1);

        int aliceCount = solve(0, n-1, piles, dp);

        int bobCount = total - aliceCount;

        return aliceCount > bobCount;
    }
}