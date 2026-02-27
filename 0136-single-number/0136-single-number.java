// using xor approach
// TC: O(n) SC: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums)
        {
            xor ^= num;
        }
        return xor;
    }
}