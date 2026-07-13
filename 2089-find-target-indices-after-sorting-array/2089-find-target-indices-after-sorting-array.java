// TC: O(n log n) after sorting the array
// SC: O(n)
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();

        int n= nums.length;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                list.add(i);
            }
        }
        return list;
    }
}