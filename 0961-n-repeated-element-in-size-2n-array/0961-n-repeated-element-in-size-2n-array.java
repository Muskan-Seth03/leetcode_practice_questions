// Approach-2
// repeated element will only be found at i-1 th and i-2 th index from ith index
// TC: O(n) SC: O(1)
class Solution {
    public int repeatedNTimes(int[] nums) {
        int m= nums.length;
        int n= m/2;
        for(int i= 2; i<m; i++)
        {
            if(nums[i] == nums[i-1] || nums[i] == nums[i-2])
            {
                return nums[i];
            }
        }
        return nums[nums.length -1];
    }
}