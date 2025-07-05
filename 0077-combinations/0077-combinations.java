class Solution {  // brute force 
    public static void f(int start, int n, int k, List<Integer>ds, List<List<Integer>> ans){
        //base case
        if(k==0)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
            for(int j= start; j<= n; j++)
            {
                ds.add(j);
                f(j + 1, n, k-1, ds, ans);
                ds.remove(ds.size()-1);
            }
       }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        f(1, n, k, ds, ans);
        return ans;        
    }
}
