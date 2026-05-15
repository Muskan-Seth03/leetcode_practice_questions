// TC: O(log n)  SC: O(1)
class Solution {
    public int findPivot(int[] nums)
    {
        int n = nums.length;
        // find min el index in array
        int l = 0;
        int r = n-1;

        while(l < r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r])
            {
                l = mid+1;
            }
            else
            {
                r = mid;
            }
        }
        return r;
    }
    public int binarySearch(int low, int high, int[] nums, int target)
    {
        int ind = -1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                ind = mid;
                break;
            }            
            else if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ind;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);

        int ind = binarySearch(0, pivot-1, nums, target);

        if(ind != -1)
        {
            return ind;
        }    

        ind = binarySearch(pivot, n-1, nums, target);

        return ind;
    }
}