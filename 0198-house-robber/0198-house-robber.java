class Solution {   //Memoization   TC: O(2^n)*O(1) 
    public int f(int[] nums, int i, int dp[])
    {
        if(i>= nums.length)
        return 0;
        if(i== nums.length -1)
        return nums[nums.length-1];

        if(dp[i]!=-1)
        return dp[i];

        int rob= nums[i] + f(nums, i+2, dp);
        int not_rob= f(nums, i+1, dp);
        dp[i]= Math.max(rob, not_rob);
        return dp[i];
    }

    public int rob(int[] nums) {
        int n= nums.length;
        int dp[]= new int [n];
        Arrays.fill(dp, -1);
        
        return f(nums, 0, dp);
    }
}