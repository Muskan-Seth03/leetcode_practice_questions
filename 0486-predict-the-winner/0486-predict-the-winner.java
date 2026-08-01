// memoization approach
// TC: O(n^2)  SC: O(n^2)
class Solution {
    public long solve(int i, int j, int[] nums, long[][] dp)
    {
        // base case
        if(i > j)
        return 0;

        if(i == j)
        return nums[i];

        if(dp[i][j] != -1)
        return dp[i][j];

        long take_i = nums[i] + Math.min(solve(i+2, j, nums, dp), solve(i+1, j-1, nums, dp));
        long take_j = nums[j] + Math.min(solve(i+1, j-1, nums, dp), solve(i, j-2, nums, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int i= 0; i<n; i++)
        {
            total += nums[i];
        }
        long dp[][] = new long[n][n];
        
        for(long d[] : dp)
        Arrays.fill(d, -1);

        long player1 = solve(0, n-1, nums, dp);
        long player2 = total - player1;

        return player1 >= player2;
    }
}