// recursion approach
// TC: O(2^n)  SC: O(n)
class Solution {
    public long solve(int i, int j, int[] nums)
    {
        // base case
        if(i > j)
        return 0;

        if(i == j)
        return nums[i];

        long take_i = nums[i] + Math.min(solve(i+2, j, nums), solve(i+1, j-1, nums));
        long take_j = nums[j] + Math.min(solve(i+1, j-1, nums), solve(i, j-2, nums));

        return Math.max(take_i, take_j);
    }
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total = 0;

        for(int i= 0; i<n; i++)
        {
            total += nums[i];
        }
        
        long player1 = solve(0, n-1, nums);
        long player2 = total - player1;

        return player1 >= player2;
    }
}