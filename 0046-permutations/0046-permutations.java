// brute force
// TC: O(n! * n)    ==> O(n!) for permutations + O(n) for putting ds into ans
// SC: O(n! * n)    ==> O(n! *n) + O(n) recursive stack space + O(n) for map + O(n) for ds
class Solution { 
    public static void f(int[] nums, boolean map[], List<Integer> ds, List<List<Integer>> ans)
    {
        //base case
        if(ds.size()==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        // pick only if position in map is not marked
        for(int i= 0; i< map.length; i++)
        {
            if(!map[i])
            {
                map[i]= true;
                ds.add(nums[i]);

                f(nums, map, ds, ans);
                
                map[i]= false;
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n= nums.length;
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        boolean [] map= new boolean[nums.length];

        f(nums, map, ds, ans);
        return ans;
    }
}