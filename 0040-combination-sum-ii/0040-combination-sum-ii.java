class Solution {    //brute force approach
    public static void f(int ind, int target, int[]candidates, List<Integer>ds, List<List<Integer>> ans){
        //base case
        if(target==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<candidates.length; i++){
            //validity check
            if(i>ind && candidates[i]== candidates[i-1]) continue;
            if(candidates[i]> target) break;

            ds.add(candidates[i]);
            f(i+1, target-candidates[i], candidates, ds, ans);
            ds.remove(ds.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        Arrays.sort(candidates);
        f(0, target, candidates, ds, ans);
        return ans;        
    }
}