// TC: O(n) single pass through array
// SC: O(n) for hashmap
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();

        map.put(0, 1);
        int currSum=0;
        int res= 0;

        for(int num: nums)
        {
            currSum+=num;

            if(map.containsKey(currSum - k))
            {
                res+= map.get(currSum-k);
            }
            
            map.put(currSum , map.getOrDefault(currSum, 0) + 1);
            
        }
        return res;
        
    }
}