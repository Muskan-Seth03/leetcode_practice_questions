class Solution {  // tabulation approach
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][]dp= new int [n][amount + 1];
        //base case 
        for (int i = 0; i <= amount; i++) 
        {
            if (i % coins[0] == 0)
                dp[0][i] = 1;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;

                if (coins[ind] <= target)
                    take = dp[ind][target - coins[ind]];
            
                dp[ind][target] = notTake + take;
            }
        }
        return  dp[n - 1][amount];
    }
}