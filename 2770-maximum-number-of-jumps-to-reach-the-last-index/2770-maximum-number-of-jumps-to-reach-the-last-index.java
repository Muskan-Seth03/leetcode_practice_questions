// recursive approach
class Solution {
    public int solve(int i, int[] nums, int target)
    {
        int n = nums.length;
        // base case
        if(i == n-1)
        return 0;

        int res = Integer.MIN_VALUE;

        for(int j=i+1; j<n; j++)
        {
            if(Math.abs(nums[i] - nums[j]) <= target)
            {
                int temp = 1 + solve(j, nums, target);
                res = Math.max(res, temp); 
            }
        }
        return res;
    }
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int result = solve(0, nums, target);
        return result < 0 ? -1 : result; 
    }
}