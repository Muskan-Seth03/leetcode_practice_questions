// TC: O(n)  SC: O(1)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;
        int i=0;
        int j = n-1;
        while(i<j)
        {
            if(nums[i] + nums[j] > target)
            {
                j--;
            }
            else if(nums[i] + nums[j] < target)
            {
                i++;
            }
            else
            return new int[]{i+1, j+1};
        }
    }
}