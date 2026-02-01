// TC: O(n)  SC: O(1)
class Solution {
    public int minimumCost(int[] nums) {
        int n= nums.length;
        int firstMin= Integer.MAX_VALUE;
        int secondMin= Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
        {
            if(nums[i] < firstMin)
            {
                secondMin= firstMin;
                firstMin= nums[i];
            }
            else if(nums[i] < secondMin)
            {
                secondMin= nums[i];
            }
        }
        return nums[0] + firstMin + secondMin;
    }
}