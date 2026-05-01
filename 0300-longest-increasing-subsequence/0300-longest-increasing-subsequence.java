// memoization approach
class Solution {
    int[][] dp;
    public int solve(int i, int prev, int[] nums)
    {
        int n= nums.length;

        if(i >= n)
        return 0;
        
        if(dp[i][prev+1] != -1)
        return dp[i][prev+1]; 

        int skip = solve(i+1, prev, nums);

        int take = (prev == -1 || nums[i] > nums[prev]) ? 1 + solve(i+1, i, nums) : 0;

        return dp[i][prev+1] = Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];

        for(int[] d: dp)
        Arrays.fill(d, -1);

        return solve(0, -1, nums);
    }
}