class Solution {  //brute force
    public void f(int ind, int target, int [] candidates, List<Integer> ds, List<List<Integer>> ans)
    {
        //base case
        if(ind==candidates.length)
        {
            if(target == 0)
            ans.add(new ArrayList<>(ds));
            return ;
        }
       
        //pick
        if(candidates[ind]<=target)
        {
            ds.add(candidates[ind]);
            f(ind, target - candidates[ind], candidates, ds, ans);
            ds.remove(ds.size()-1);
        }
        //not pick
        f(ind+1, target, candidates, ds, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        f(0, target, candidates, ds, ans);
        return ans;
    }
}