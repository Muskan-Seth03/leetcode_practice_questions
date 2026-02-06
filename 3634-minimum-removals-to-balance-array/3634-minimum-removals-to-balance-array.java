// two pointer approach
// TC: O(n log n)  SC: O(1)
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n= nums.length;

        Arrays.sort(nums);
        int i=0;
        int j=0;
        int len= 0;

        while(i < n)
        {
            while(j < n && nums[j] <= (long) nums[i] * k)
            {
                j++;
                // track length of largest balanced array
            }
            len = Math.max(len, j - i);
            i++;
        }
        return n - len;
    }
}