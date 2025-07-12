class Solution {  // using custom binary search 
    public static int f(int nums[], int n, int target)
    {
        int low= 0, high = n-1;
        while(low<= high)
        {
            int mid= low +(high - low)/2;
            if(nums[mid]== target)
            return mid;
            // we gotta find the sorted half that contains our target, 
            //so that we can eliminate other half 
            // check if the left half is sorted
            if( nums[low]<= nums[mid])
            {
                if( nums[low]<= target && target<= nums[mid])
                {
                    high= mid-1;
                }
                else
                low= mid+1;
            }
            // check if the right half is sorted
            // either of the 2 half will be sorted 
            else
            {
                if(nums[mid]<= target && target<= nums[high])
                {
                    low= mid+1;
                }
                else
                high= mid-1;
            } 
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int n= nums.length;
        return f(nums, n , target);   
    }
}