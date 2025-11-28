// Kadane Algorithm  (using 2 loops)
// TC:O(n)
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n= nums.length;
        int currSubSum= nums[0];
        int maxSubSum=nums[0];
        
        // kadane for finding maxSubSum
        for(int i=1; i<n; i++){
            currSubSum= Math.max(nums[i], currSubSum + nums[i]);
            maxSubSum= Math.max(currSubSum, maxSubSum);
        }

        currSubSum= nums[0];
        int minSubSum= nums[0];
        // kadane for finding minSubSum
        for(int i=1; i<n; i++){
            currSubSum= Math.min(nums[i], currSubSum + nums[i]);
            minSubSum= Math.min(minSubSum, currSubSum);
        }
        return Math.max(maxSubSum, Math.abs(minSubSum));
    }
}