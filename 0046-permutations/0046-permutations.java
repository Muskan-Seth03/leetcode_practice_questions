// space optimised approach
// TC: O(n!* n)
// SC: O(n) recursive stack space
class Solution { 
    public static void f(int ind, int[] nums, List<List<Integer>> ans)
    {
        //base case
        if(ind==nums.length)
        {
            List<Integer> ds= new ArrayList<>();
            for(int num: nums)
            ds.add(num);
            ans.add(new ArrayList<>(ds));
            return;
        }
        // swap 
        for(int i= ind; i< nums.length; i++)
        {
            swap(i, ind, nums);          
            f(ind+1, nums, ans);
            swap(i, ind, nums);              
        }
    }

    public static void swap(int i, int j, int []nums)
    {
        int temp= nums[i];
        nums[i]= nums[j];
        nums[j]= temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        int n= nums.length;
        List<List<Integer>> ans= new ArrayList<>();
      
        f(0, nums, ans);
        return ans;
    }
}