class Solution {  // tabulation approach TC:O(n*k)  SC:O(n*k)
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int total_sum=0;
        for(int num: nums)
        {
            total_sum +=num;
        }
        if(total_sum % 2!= 0)
        return false;   // cant be divided equally
        int k= total_sum /2;
        boolean [][]dp= new boolean [n][k+1];

        //base case 
        for(int ind=0; ind<n; ind++)
        dp[ind][0]= true;

      // Base case: Only one element to consider (nums[0])
        if (nums[0] <= k)
            dp[0][nums[0]] = true;

        for(int ind=1; ind<n; ind++)
        {
            for(int target= 1; target<= k; target++)
            {
                boolean notTake= dp[ind-1][target];
                boolean take= false;
                if(nums[ind]<= target)
                {
                    take= dp[ind-1][target-nums[ind]];
                }
                dp[ind][target]= take || notTake;
            }
        }
        return dp[n-1][k];
    } 
}
