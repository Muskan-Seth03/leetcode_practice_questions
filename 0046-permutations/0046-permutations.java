class Solution {  //better approach

    public void f(int ind, int [] nums, List<List<Integer>> result)
    {
        //base case
        List<Integer> ds = new ArrayList<>();
        if(ind== nums.length)
        {
            for(int i=0; i<nums.length; i++)
            {
                ds.add(nums[i]);
            }
        result.add(new ArrayList<>(ds));
        return;
        }

        for(int i=ind; i<nums.length; i++)
        {
            swap(ind, i, nums);
            f(ind+1, nums, result);
            swap(ind, i, nums);

        }
    }

    public void swap(int i, int j, int nums[])
    {
        int t= nums[i];
        nums[i]= nums[j];
        nums[j]= t;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();

        f(0, nums, result);

        return result;

        
    }
}