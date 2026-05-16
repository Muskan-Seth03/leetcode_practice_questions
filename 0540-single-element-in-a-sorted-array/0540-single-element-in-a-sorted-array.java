// TC: O(log n)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l < r)
        {
            int mid = l +(r-l)/2;
            boolean isEven = (r - mid) % 2 == 0;

            if(nums[mid] == nums[mid+1])
            {
                // check no of el to the right of mid
                if(isEven)
                {
                    // go right
                    l = mid + 2;
                }
                else
                {
                    r = mid - 1;
                } 
            }
            else
            {
                if(isEven)
                {
                    r = mid;
                }
                else
                {
                    l = mid+1;
                }
            }
        }
        return nums[r];
    }
}