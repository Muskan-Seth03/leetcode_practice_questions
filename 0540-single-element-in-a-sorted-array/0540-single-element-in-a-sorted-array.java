class Solution {  // brute force approach-2   XOR   TC: O(n)  SC: O(1) 
    public int singleNonDuplicate(int[] nums) {
        int n= nums.length;
        int xor= 0;
        for(int i=0; i<n;i++)
        {
            xor^= nums[i];
        }
        return xor;
    }
}
