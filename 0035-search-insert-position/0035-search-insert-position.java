class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans=0;
        int low=0; int high=n-1;
        while(low<=high)
        {
            int mid= (low+high)/2;
            if(target<= nums[mid])
            {
                ans= mid;
                high= mid-1;
            }
            else 
            {
                ans=mid+1;
                low= mid+1;
            }
        }
        return ans;
    }
}