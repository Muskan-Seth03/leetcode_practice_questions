class Solution {  // TC: O(log n)  SC: O(1)
    public static int f(int nums[], int n)
    {
        int low= 0, high = n-1;
        int mini= Integer.MAX_VALUE;
        while(low<= high)
        {
            int mid= low +(high - low)/2;

            // we gotta find the sorted half that contains our target, 
            //so that we can eliminate other half 
            // check if the left half is sorted

            if( nums[low]<= nums[mid])
            {
                mini= Math.min(mini, nums[low]);
                low= mid+1;
            }
            // check if the right half is sorted
            // either of the 2 half will be sorted 
            else
            {
                mini= Math.min(mini, nums[mid]);
                high= mid-1;
            } 
        }
        return mini;
    }

    public int findMin(int[] nums) {
        int n= nums.length;
        return f(nums, n);   
        
    }
}

  