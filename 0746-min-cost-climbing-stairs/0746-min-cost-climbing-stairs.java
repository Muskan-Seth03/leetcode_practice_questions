// memoization 
class Solution {
    public int solve(int ind, int[] cost, int[] dp)
    {
        if(ind >= cost.length)
        return 0;

        if(dp[ind] != -1)
        return dp[ind];

        int a = cost[ind] + solve(ind+1, cost, dp);
        int b = cost[ind] + solve(ind+2, cost, dp);

        return dp[ind] = Math.min(a, b);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }
}