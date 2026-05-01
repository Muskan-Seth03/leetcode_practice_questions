// memoization approach
class Solution {
    int[][] dp;
    public int solve(int i, int prev, int[][] pairs)
    {
        int n = pairs.length;

        if(i >= n)
        return 0;
        
        if(dp[i][prev+1] != -1)
        return dp[i][prev+1]; 

        int skip = solve(i+1, prev, pairs);

        int take = (prev == -1 || pairs[i][0] > pairs[prev][1]) ? 1 + solve(i+1, i, pairs) : 0;

        return dp[i][prev+1] = Math.max(skip, take);
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        dp = new int[n+1][n+1];

        for(int[] d: dp)
        Arrays.fill(d, -1);

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        return solve(0, -1, pairs);
    }
}
