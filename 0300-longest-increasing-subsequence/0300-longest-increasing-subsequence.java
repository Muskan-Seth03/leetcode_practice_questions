class Solution {   // space optimised approach 
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[]curr= new int[n+1];
        int[]next= new int[n+1];

        for(int ind= n-1; ind>=0; ind--)
        {
            for(int prev_index= ind-1; prev_index>=-1; prev_index--)
            {
                int not_take= 0 + next[prev_index+ 1];
                int take= 0;
                if(prev_index==-1 || nums[ind]> nums[prev_index])
                {
                    // prev_index= ind;
                    take= 1 + next[ind+1];
                }
                curr[prev_index+1]=Math.max(take, not_take);
            }
            next= curr.clone();
        }
        return next[-1 + 1]; 
    }
}