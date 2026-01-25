// TC: O(n log n)  SC: O(1)
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n= nums.length;
        Arrays.sort(nums);

        int max, min=0;
        int diff= 0;
        int minDiff = Integer.MAX_VALUE;

        int i= 0;
        int j= i+k-1;

        while(j < n)
        {
            max= nums[j];
            min= nums[i];
            diff= max - min;

            minDiff= Math.min(diff, minDiff);
            i++;
            j++;
        }
        return minDiff;
    }
}