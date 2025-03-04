class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int n= nums.length;
        int low=0;
        int high= n-1;
        int c=0;

        while(low<=high)
        {
            if(nums[low] < k)
            {
                c++;  
            }
            
            low++;
        }

        return c;
    }
}