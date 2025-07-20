class Solution {// brute force
    public int findPeakElement(int[] nums) {
        int n= nums.length;

        for( int i=0; i < n; i++)
        {
            // edge case
            if(n==1)
            return 0;
            if(i==0)
            {
                if(nums[i]> nums[i+1])
                {
                    return 0;
                }
            }
            else if(i == n-1)
            {
                if(nums[i] > nums[i-1])
                {
                    return n-1;
                }
            }

            else if(nums[i]> nums[i-1] && nums[i] > nums[i+1])
            {
                return i;
            }

        }
        return -1;
    }
}