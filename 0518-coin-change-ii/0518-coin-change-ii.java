class Solution {  // memoization approach
    public static int f(int ind, int target, int[]coins, int[][]dp)
    {
        //base case 
        if(ind==0)
        {
            if(target % coins[0] ==0)
            return 1;
            else
            return 0;
        }
        if(dp[ind][target]!=-1)
        return dp[ind][target];

        int notTake = f(ind - 1, target, coins, dp);
        int take = 0;

        if (coins[ind] <= target)
        take = f(ind, target - coins[ind], coins, dp);
    
        return dp[ind][target] = notTake + take;
    }
    public int change(int amount, int[] coins) {
        int n= coins.length;
        
        int[][]dp= new int [n][amount + 1];
        for(int row[]: dp)
        Arrays.fill(row, -1);

        return f(n-1, amount, coins, dp);
    }
}
       