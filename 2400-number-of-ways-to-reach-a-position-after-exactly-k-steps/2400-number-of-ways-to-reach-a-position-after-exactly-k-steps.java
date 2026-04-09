// memoization approach
class Solution {
    int MOD = 1_000_000_007;
    public int solve(int startPos, int endPos, int curr, int k, int[][]dp)
    {
        if(k == 0)
        {
            if(curr == endPos)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(dp[curr + 1001][k] != -1)
        return dp[curr + 1001][k];

        if(Math.abs(curr - endPos) > k) return 0;
        
        int right = solve(startPos, endPos, curr+1, k-1, dp) % MOD;
        int left = solve(startPos, endPos, curr-1, k-1, dp) % MOD;        

        return dp[curr + 1001][k] = (left + right) % MOD;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3001][1001];

        for(int[] d: dp)
        {
            Arrays.fill(d, -1);
        }

        return solve(startPos, endPos, startPos, k, dp);
    }
}