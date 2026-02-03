class Solution {
    public boolean isTrionic(int[] nums) {
        int n= nums.length;
        int i=0;
        while(i < n-1 && nums[i] < nums[i+1])
        {
            i++;
        }
        if(i == 0)
        return false;

        int p = i;
        while(i < n-1 && nums[i] > nums[i+1])
        {
            i++;
        }
        if( p == i)
        // no el present in btw p and expected q
        return false;

        int q = i;
        while(i < n-1 && nums[i] < nums[i+1])
        {
            i++;
        }  
        if(q == i)
        return false;

        return (i == n-1);
    }
}