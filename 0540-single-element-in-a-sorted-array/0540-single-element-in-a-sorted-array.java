class Solution {  // brute force approach-1
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        // edge case
        if(n==1)
        return nums[0];

        for( int i=0; i<= n-1; i++)
        {
            if(i==0)
            {
                if(nums[i]!= nums[i+1])
                {
                    return nums[i];
                }
            }
            else if(i==n-1)
            {
                if(nums[i-1] != nums[i])
                {
                    return nums[i];
                }
            }
            else if( nums[i]!= nums[i-1]  && nums[i] != nums[i+1])
            return nums[i];
        }
        return -1;        
    }
}