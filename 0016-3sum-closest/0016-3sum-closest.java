// TC: O(n log n) + O(n^2)   SC: O(1)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n= nums.length;
        Arrays.sort(nums);
        int i = 0;
        int closestSum = nums[0] + nums[1] + nums[2];

        while(i <= n-3)
        {
            int j= i+1;
            int k= n-1;

            while(j < k)
            {
                int currSum = nums[i] + nums[j] + nums[k];

                if(currSum < target)
                {
                    j++;
                } 
                else
                {
                    k--;
                }
                if(Math.abs(target - currSum) < Math.abs(target - closestSum))
                {
                    closestSum = currSum;
                } 
           }
            i++;                        
        }
        return closestSum;
    }
}