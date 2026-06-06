class Solution {
    public int[] leftRightDifference(int[] nums) {
        int left_sum=0;
        int total_sum=0;
        int[] result = new int[nums.length];
        for(int j=0;j< nums.length; j++)
        {
            total_sum+=nums[j];
        }

        for(int i=0;i<nums.length;i++)
        {
            int right_sum= total_sum - left_sum - nums[i];
            result[i]= Math.abs(right_sum-left_sum); 
           
            left_sum+=nums[i];            
        }
        return result;
    }
}
