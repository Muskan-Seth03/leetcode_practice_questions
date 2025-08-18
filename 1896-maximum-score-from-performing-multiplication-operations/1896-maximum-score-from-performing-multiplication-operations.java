// memoization approach 
// TC: O(m*m) 
// SC: O(m*m)  
class Solution {
    public static int f(int i, int left, int[]nums, int[] mult, int [][]dp)
    {
        int n= nums.length;
        int m= mult.length;

        // base case
        if(i== m)  //when all multipliers are used, stop.
        return 0;

        if(dp[i][left]!=-1)
        return dp[i][left];

        int right= n-1 -(i- left);

        int leftSum=0;
        int rightSum=0;
        // pick left
        leftSum= leftSum + (nums[left] * mult[i]) + f(i+1, left+1, nums, mult, dp);
        // pick right
        rightSum += (nums[right]* mult[i]) + f(i+1, left, nums, mult, dp);
        return dp[i][left]= Math.max(leftSum , rightSum);

    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int n= nums.length;
        int m= multipliers.length;

        int dp[][]= new int[m][m];
        for(int [] row: dp)
            Arrays.fill(row, -1);

        return f(0, 0, nums, multipliers, dp);
    }
}