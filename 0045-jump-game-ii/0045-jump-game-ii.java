// memoization approach
class Solution {
    public int solve(int i, int[] nums, int[] dp)
    {
        int n = nums.length;

        if(i >= n-1)
        return 0;

        if(dp[i] != -1)
        return dp[i];
        
        int res = Integer.MAX_VALUE;

        for(int j=1; j <= nums[i]; j++)
        {
            if(i+j < n)
            {
                int temp = solve(i+j, nums, dp);

                if(temp != Integer.MAX_VALUE) 
                {
                    res = Math.min(res, 1 + temp);
                }
            }
        }
        return dp[i] = res;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }
}