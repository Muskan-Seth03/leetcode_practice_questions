// Approach-1
// TC: O(n) SC: O(n)
class Solution {
    public int repeatedNTimes(int[] nums) {
        int m= nums.length;
        int n= m/2;
        Map<Integer, Integer> map= new HashMap<>();

        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) > 1)
            {
                return num;
            }
        }
        return 0;
    }
}