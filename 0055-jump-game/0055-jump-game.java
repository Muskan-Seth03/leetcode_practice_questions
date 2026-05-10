// memoization approach
// TC: O(n^2)  SC: O(n)
class Solution {
    public boolean solve(int i, int[] nums, int[] dp)
    {
        int n = nums.length;

        if(i >= n-1)
        return true;

        if(dp[i] != -1)
        return dp[i] == 1;

        boolean temp = false;
        for(int j=1; j <= nums[i]; j++)
        {
            temp = solve(i+j, nums, dp);
            if(temp == true)
            {
                dp[i] = 1;
                return true;
            }
        }
        dp[i] = 0;
        return false;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, nums, dp);
    }
}