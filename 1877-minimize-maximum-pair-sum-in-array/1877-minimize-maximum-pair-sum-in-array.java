// TC: O(n log n)  SC: O(1)
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        int i=0;
        int j=n-1;
        int res= 0;
        while(i<j)
        {
            res= Math.max(res, nums[i] + nums[j]);
            i++;
            j--;
        }       
        return res;
    }
}