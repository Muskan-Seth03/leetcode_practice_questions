// Kadane algortihm
// TC: O(n)
class Solution {
    public int maxSubArray(int[] nums) {
        int n= nums.length;
        int currSubSum= nums[0];
        int maxSubSum=nums[0];
        
        // kadane for finding maxSubSum
        for(int i=1; i<n; i++){
            currSubSum= Math.max(nums[i], currSubSum + nums[i]);
            maxSubSum= Math.max(currSubSum, maxSubSum);
        }
        return maxSubSum;
    }
}
