class Solution {   // brute force
    public static void f(int start, int tar, int k, List<Integer>ds, List<List<Integer>> ans){
        //base case
        if(k==0)
        {
            if(tar==0)
            {
                ans.add(new ArrayList<>(ds));
                return;
            }
        }
        if(start > tar)
        return;

        for(int j= start; j<= 9; j++)
        {
            ds.add(j);
            f(j + 1, tar - j, k-1, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        f(1, n, k, ds, ans);
        if(ans.size()!=0)
        return ans;
        else
        return new ArrayList<>();

    }
}