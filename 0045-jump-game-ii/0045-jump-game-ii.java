// tabulation approach
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[n-1]= 0;

        for(int i=n-2; i>=0; i--)
        {
            int res = Integer.MAX_VALUE;
            
            for(int j=1; j <= nums[i]; j++)
            {
                if(i+j < n)
                {
                    int temp = dp[i+j];

                    if(temp != Integer.MAX_VALUE) 
                    {
                        res = Math.min(res, 1 + temp);
                    }
                }
            }
            dp[i] = res;
        }
        return dp[0];
    }
}