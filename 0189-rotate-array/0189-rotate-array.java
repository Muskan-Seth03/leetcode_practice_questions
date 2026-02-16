// brute force -- shift one by one 
// TC: O(n*k)  SC: O(1)
class Solution {
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        for(int i=0; i<k; i++)
        {
            int temp = nums[n-1];
            int j = n-2;
            while(j >= 0)
            {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }
}