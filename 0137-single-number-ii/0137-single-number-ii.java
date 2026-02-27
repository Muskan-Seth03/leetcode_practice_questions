// bit manipulation
// TC: O(n * 32)  SC: O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int k=0; k<32; k++)
        {
            int countOnes= 0;
            int countZeros= 0;
            for(int num: nums)
            {
                if((num & (1 << k)) == 0)
                {
                    countZeros++;
                }
                else
                countOnes++;
            }
            if(countOnes % 3 == 1)
            {
                // kth bit needs to be set
                res = res | (1 << k);
            }
        }
        return res;
    }
}