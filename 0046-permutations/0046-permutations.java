class Solution {
    public void permutation(int [] nums, List<Integer> ds, boolean map[], List<List<Integer>>result)
    {
        if(ds.size()==nums.length)
        {
            result.add(new ArrayList<>(ds));
            return ;
        }

        for(int i=0; i<map.length; i++)
        {
            if(!map[i])
            {
                ds.add(nums[i]);
                map[i]=true;

                permutation(nums, ds, map, result);

                ds.remove(ds.size()-1);
                map[i]=false;
            }
        }

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        boolean map[]= new boolean[nums.length];

        permutation(nums, ds, map, result);

        return result;
    }
}