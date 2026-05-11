// recursion approach
class Solution {
    public boolean solve(int i, int[] nums, boolean[] visi)
    {
        int n = nums.length;

        if(i<0 || i >=n)
        return false;

        // cycle encountered
        if(visi[i] == true)
        return false;
        
        if(nums[i] == 0)
        return true;

        visi[i] = true;

        // cyclicity --> need of visited array
        return solve(i + nums[i], nums, visi) || solve(i - nums[i], nums, visi);
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visi = new boolean[n];
        return solve(start, arr, visi);
    }
}