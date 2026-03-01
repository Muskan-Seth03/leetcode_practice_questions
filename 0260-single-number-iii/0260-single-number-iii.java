// TC: O(n)  SC: O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums)
        {
            xor ^= num;
        }        
        // mask => right most set bit search
        int mask= xor & (-xor);
        int xor1= 0;
        int xor2= 0;
        for(int num: nums)
        {
            if((mask & num) == 0)
            {
                xor1 ^= num;
            }
            else
            {
                xor2 ^= num;
            }
        }
        return new int[] {xor1, xor2};
    }
}