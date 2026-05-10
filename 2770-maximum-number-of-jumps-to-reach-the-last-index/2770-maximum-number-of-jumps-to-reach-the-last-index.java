// recursion + memoization approach
class Solution {
    public int solve(int i, int[] nums, int target, int[] dp)
    {
        int n = nums.length;
        // base case
        if(i == n-1)
        return 0;

        if(dp[i] != Integer.MIN_VALUE)
        return dp[i];

        int res = Integer.MIN_VALUE;

        for(int j=i+1; j<n; j++)
        {
            if(Math.abs(nums[i] - nums[j]) <= target)
            {
                int temp = 1 + solve(j, nums, target, dp);
                res = Math.max(res, temp); 
            }
        }
        return dp[i] = res;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MIN_VALUE);

        int result = solve(0, nums, target, dp);
        return result < 0 ? -1 : result; 
    }
}