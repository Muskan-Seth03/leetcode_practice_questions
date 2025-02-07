class Solution {   ///Optimal approach   TC:O(N)  SC: O(1)
    public int maxSubArray(int[] nums) {   //Kadane algorithm
        int n= nums.length;
        int max_sum=Integer.MIN_VALUE;

        int sum=0;
        for(int i =0; i<n; i++)
        {
            sum+= nums[i];

            max_sum= Math.max(max_sum, sum);

            if(sum<0)
            sum=0;
        }
        return max_sum;
    }
}