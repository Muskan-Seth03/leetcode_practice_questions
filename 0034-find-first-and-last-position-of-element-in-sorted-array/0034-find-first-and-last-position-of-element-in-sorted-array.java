class Solution {
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
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int pivot = binarySearch(0, n-1, nums, target);

        if(pivot == -1)
        return new int[]{-1, -1};

        int index = pivot;

        while(index > 0 && nums[index] == nums[index-1])
        {
            index--;
        }       
        int ind1= index;

        index = pivot;
        while(index < n-1 && nums[index] == nums[index+1])
        {
            index++;
        } 
        int ind2 = index;
        return new int[]{ind1, ind2};
    }
}