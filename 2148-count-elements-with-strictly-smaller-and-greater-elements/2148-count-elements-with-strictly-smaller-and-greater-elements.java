// TC: O(n)  SC: O(1)
class Solution {
    public int countElements(int[] nums) {
        int n= nums.length;
        // find the min and max el in the array 
        int max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        for(int i=0; i<n; i++)
        {
            if(nums[i] > max)
            {
                max= nums[i];
            }
            if (nums[i] < min)
            {
                min= nums[i];
            }
        }
        int count = 0;
        for(int num: nums)
        {
            if(num != min && num != max)
            {
                count++;
            }
        }
        return count;        
    }
}