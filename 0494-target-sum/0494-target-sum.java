class Solution {   //tabulation approach 
    public int findTargetSumWays(int[] nums, int target) {
        int n= nums.length;
        int totalSum=0;
        for(int num: nums)
        totalSum+=num;

        if((totalSum - target) < 0  || (totalSum - target)%2 !=0)
        return 0;
        
        target = (totalSum - target) / 2;

        int [][]dp= new int[n][target+1];
        //base case
            if(nums[0]==0)
            dp[0][0]=2;
            else
            dp[0][0]= 1;     // not pick

            if(nums[0]!=0 && nums[0]<= target)
            dp[0][nums[0]]=1;     //pick 
        

        for(int ind=1; ind<n; ind++)
        {
            for(int tar= 0; tar<= target; tar++)
            {
                int notTake= dp[ind-1][tar];
                int take=0;
                if(nums[ind]<=tar)
                take= dp[ind-1][tar-nums[ind]];
                dp[ind][tar]= take + notTake;
            }
        }
        return dp[n-1][target];        
    }
}