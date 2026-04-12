class Solution {
    public int solve(int i, int[] nums, int n, int[] dp)
    {
        if(i > n) return 0;

        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(i+2, nums, n, dp);
        int skip = solve(i+1, nums, n, dp);

        return dp[i] = Math.max(steal, skip);
    }      
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
        return nums[0];

        if(n == 2)
        return Math.max(nums[0], nums[1]);

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int pick_oth_index =  solve(0, nums, n-2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1); 

        int pick_1st_index = solve(1, nums, n-1, dp2);

        return Math.max(pick_oth_index, pick_1st_index);  
    }
}