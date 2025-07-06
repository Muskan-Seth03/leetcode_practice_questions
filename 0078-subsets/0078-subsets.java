class Solution {   // brute force 
    public static void f(int ind, int[]nums, List<Integer> ds, List<List<Integer>> ans){
        if(ind==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        //pick
        ds.add(nums[ind]);
        f(ind+1, nums, ds, ans);
        ds.remove(ds.size()-1);
        f(ind+1, nums, ds, ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        f(0, nums, ds, ans);
        return ans;
               
    }
}