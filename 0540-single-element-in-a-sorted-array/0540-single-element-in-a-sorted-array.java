class Solution {  //binary search
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        int low= 0;
        int high= n-1;
        while(low <= high)
        {
            // edge case
            if(n==1)
            return nums[0];
            if(nums[0]!= nums[1])
            return nums[0];
            if( nums[n-1] != nums[n-2])
            return nums[n-1];

            int mid = low + (high- low)/2;
            // Check if mid is the single element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            //elimination
        //if match is of (even, odd) type then it is sure that single elment is in right half. 
            if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 ==1 && nums[mid] == nums[ mid-1] ))
            {
                low= mid+1;
            }
            else
            {
                high= mid-1;
            }
        }
        return -1;
    }
}