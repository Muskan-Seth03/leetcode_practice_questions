class Solution {   // LIS approach 
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[]dp= new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;
        for(int ind=0; ind<=n-1; ind++)
        {
            for(int prev=0; prev<ind; prev++)
            {
                if(nums[prev] < nums[ind])
                {
                    dp[ind]=Math.max(1+dp[prev], dp[ind]);
                }
            }
            maxi= Math.max(maxi, dp[ind]);
        }
        return maxi;       
    }
}