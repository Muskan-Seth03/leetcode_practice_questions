// backtracking approach
// TC: O(n * n!)  SC: O(n! + 2n)
class Solution {
    int n;
    Set<Integer> set;
    List<List<Integer>> res;
    public void solve(List<Integer> temp, int[] nums)
    {
        // base case
        if(temp.size() == n)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0; i<n; i++)
        {
            if(!set.contains(nums[i]))
            {
                temp.add(nums[i]);
                set.add(nums[i]);

                solve(temp, nums);
                
                temp.remove(temp.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        
        res = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>();
        set= new HashSet<>();
        
        solve(temp, nums);
        return res;
    }
}