// TC: O(n)  SC: O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        int n= nums.length;
        int k=0;

        for(int i=0; i < n-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        // for(int i=0; i<n; i++)
        // System.out.println(nums[i]);
        for(int i=0; i<n; i++)
        {
            if(nums[i] != 0)
            {
                nums[k++] = nums[i]; 
            }
        }
        while(k < n)
        {
            nums[k++]= 0;
        }
        return nums;
    }
}