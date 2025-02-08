class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n= nums.length;
        int pos_ind=0;
        int neg_ind=1;

        int ans[]= new int [nums.length];
        for(int i=0; i<n; i++)
        {
            if(nums[i]>0)
            {
                ans[pos_ind]= nums[i];
                pos_ind+=2; 

            }
            else
            {
                ans[neg_ind]= nums[i];
                neg_ind+=2;

            }
        }
        return ans;
    }
}