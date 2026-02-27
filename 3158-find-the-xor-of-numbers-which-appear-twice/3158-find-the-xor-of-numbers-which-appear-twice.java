// TC: O(n)  SC: O(n)
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int xor = 0;
        for( Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int val = entry.getValue();
            int key = entry.getKey();
            if(val == 2)
            {
                xor ^= key;
            }
        }
        return xor;
    }
}