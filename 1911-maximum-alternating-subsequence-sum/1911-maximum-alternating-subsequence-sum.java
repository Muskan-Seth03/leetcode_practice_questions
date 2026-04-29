// memoization approach 
// TC: O(n)  SC: O(n)
class Solution {
    long[][] dp;
    public long solve(int ind, int[] nums, boolean flag)
    {
        int n= nums.length;
        if(ind >= n)
        return 0;
        
        int f = flag ? 1 : 0;

        if(dp[ind][f] != -1)
        return dp[ind][f];

        long skip = solve(ind+1, nums, flag);

        long val = nums[ind];
        if(flag == false)
        {
            val = -val;
        } 
        long take = val + solve(ind+1, nums, !flag);

        return dp[ind][f] = Math.max(skip, take); 
    }
    public long maxAlternatingSum(int[] nums) {
        int n= nums.length;
        dp = new long[n][2];
        
        for(long[] d: dp)
        Arrays.fill(d, -1);

        return solve(0, nums, true);
    }
}