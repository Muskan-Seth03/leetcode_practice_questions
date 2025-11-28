// using Kadane algorithm   
// TC: O(n)  SC:O(n)  for prefixSum array
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n= nums.length;
        // find prefix sum
        long []prefixSum= new long[n];
        prefixSum[0]= nums[0];

        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
       
        long maxSum= Long.MIN_VALUE;
        for(int start=0; start < k; start++){
            int i=start;
            long currSum=0;
            // calculate the  currSum, subSum and maxSum
            while(i<n && i+k-1 < n){
                
                int j= i + k - 1;
                
                long subSum= prefixSum[j]- (i>0 ? prefixSum[i-1] : 0) ;

                currSum= Math.max(subSum, currSum + subSum);

                maxSum= Math.max(currSum, maxSum);     

                i= i+k;           
            }
        }
        return maxSum;       
    }
}