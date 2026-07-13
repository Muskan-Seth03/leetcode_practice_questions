// TC: O(n)    SC: O(n)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int less= 0;
        int equal =0;

        boolean flag = false;
        for(int num: nums)
        {
            if(num == target)
            {
                equal++;
                flag = true;
            }
            else if(num < target)
            {
                less++;
            }
        }
        if(!flag) 
        return new int[]{-1, -1};

        int[] res = new int[2];
        int k = 0;

        res[0] = less;
        res[1] = less + equal - 1;
        
        return res;       
    }
}