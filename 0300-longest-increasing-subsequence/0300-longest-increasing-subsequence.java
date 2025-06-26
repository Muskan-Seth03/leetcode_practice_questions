class Solution {   // memoization approach 
    public static int f(int ind, int prev_index, int n, int[]nums, int[][]dp)
    {
        // base case
        if(ind==n)
        return 0;

        if(dp[ind][prev_index+1]!=-1)
        return dp[ind][prev_index + 1];

        int not_take= 0 + f(ind + 1, prev_index, n, nums,dp);
        int take= 0;
        if(prev_index==-1 || nums[ind]> nums[prev_index])
        {
            // prev_index= ind;
            take= 1 + f(ind+1, ind, n, nums,dp);
        }
        return dp[ind][prev_index+1]=Math.max(take, not_take);

    }
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[][]dp= new int [n][n+1];
        for(int []row:dp)
        Arrays.fill(row, -1);
        return f(0, -1, n, nums, dp);        
    }
}