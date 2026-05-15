class Solution {
    public int findPivot(int[] nums)
    {
        int n = nums.length;
        // find min el index in array
        int l = 0;
        int r = n-1;
        // skip duplicate el from both ends
        while(l<r && nums[l] == nums[l+1])
        {
            l++;
        }
        while(l<r && nums[r] == nums[r-1])
        {
            r--;
        }
        
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
    public boolean binarySearch(int low, int high, int[] nums, int target)
    {
        boolean ind = false;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                ind = true;
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
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);

        if(binarySearch(0, pivot-1, nums, target))
        return true;

        return binarySearch(pivot, n-1, nums, target);
    }
}