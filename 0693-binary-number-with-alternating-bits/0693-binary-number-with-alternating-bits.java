// M-2 manual binary no creation
// TC: O(log n)  SC: O(1)
class Solution {
    public boolean hasAlternatingBits(int n) {
        int currBit = n % 2;
        n = n/2;

        while(n > 0)
        {
            if(currBit == n % 2)
            {
                return false;
            }
            currBit = n % 2;
            n= n/2;
        }        
        return true;
    }
}