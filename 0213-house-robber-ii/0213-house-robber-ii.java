// TCbulation
// TC: O(n)   SC: O(1)
class Solution {
    public int solve(int l, int[] nums, int r)
    {
        int prev= 0;
        int prevPrev =0;
        for(int i = l; i <= r; i++)
        {
            int steal = nums[i] + prevPrev;
            int skip = prev;
            int temp = Math.max(steal, skip);

            prevPrev = prev;
            prev = temp;
        }
        return prev;
    }   
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1)
        return nums[0];

        if(n == 2)
        return Math.max(nums[0], nums[1]);

        int pick_oth_index =  solve(0, nums, n-2);

        int pick_1st_index = solve(1, nums, n-1);

        return Math.max(pick_oth_index, pick_1st_index);  
    }
}