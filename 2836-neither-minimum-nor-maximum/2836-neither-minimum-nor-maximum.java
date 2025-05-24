//  TC:O(n) SC:O(1)
// mirco - optimization approach without using Arrays.stream()
class Solution { 
    public int findNonMinOrMax(int[] nums) {
        int n= nums.length;
        if(n < 3)
        return -1;
        
        int min = nums[0], max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        for(int num: nums)
        {
            if(num != max && num != min)
            return num;
        }
        return -1;

    }
}