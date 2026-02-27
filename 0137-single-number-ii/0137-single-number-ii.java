// sorting based approach
// TC: O(n log n)  SC: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int ans= -1;
        for(int i=0; i<n-2; i+=3)
        {
            if(nums[i] != nums[i+2])
            {
                return nums[i];
            }
        }
        return nums[n-1];
    }
}