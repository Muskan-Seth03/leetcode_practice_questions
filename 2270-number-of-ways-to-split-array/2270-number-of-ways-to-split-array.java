// TC: O(n)   SC: O(n)
class Solution {
    public int waysToSplitArray(int[] nums) {
        // create prefix sum array
        int n= nums.length;
        if(n < 2){
            return -1;
        }

        long[] prefixSum= new long[n];

        prefixSum[0]=nums[0];
        for(int i=1; i<n; i++){
            prefixSum[i]= prefixSum[i-1] + nums[i];
        }
        
        int count=0;

        for(int i=0; i<n-1; i++){
        long suffixSum= prefixSum[n-1] - prefixSum[i];
            if(prefixSum[i] >= suffixSum){
                count++;
            }
        }

        return count;
    }
}