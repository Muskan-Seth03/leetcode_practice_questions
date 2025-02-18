class Solution {    // better approach (sorting) TC: O(n logn)  SC= O(1)
    public int longestConsecutive(int[] nums) {
        int n= nums.length;
        if(n == 0)
        return 0;
        Arrays.sort(nums);     //TC:(nlogn)
        int count=1;
        int longest=1;
        int last_smaller= Integer.MIN_VALUE;
        for(int i=0; i<n ; i++)
        {
            if(nums[i]-1 == last_smaller)  // found consecutive el
            {
                count++;
                last_smaller= nums[i];
            }
            else if( nums[i] != last_smaller)  //found a new el ...maybe new sequence
            {
                count=1;
                last_smaller= nums[i];

            }
            //else if repeated el found same as last_smaller =====>> skip it
            longest= Math.max(longest, count);

        }
        return longest;
    }
}