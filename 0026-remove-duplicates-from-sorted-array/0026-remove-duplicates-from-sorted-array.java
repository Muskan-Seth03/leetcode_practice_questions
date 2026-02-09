// TC: O(n)  SC: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        int k=0;
        for(int i=0; i<n-1; i++)
        {
            if(nums[i] != nums[i+1])
            {
                nums[k++]= nums[i]; 
            }
        }
        nums[k++] = nums[n-1];
        return k;
    }
}