// TC: O(n) without sorting the array
// SC: O(1)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        int n= nums.length;

        int less = 0;
        int equal = 0;
        // calculate count of el less than target and el equal to target
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                equal++;
            }
            else if(nums[i] < target)
            {
                less++;
            }
        }

        for(int i = less; i< less+equal; i++)
        {
            list.add(i);
        }

        return list;
    }
}