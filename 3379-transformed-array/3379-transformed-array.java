// TC: O(n)  SC: O(1)
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n= nums.length;

        int[] res= new int[n];
        for(int i=0; i< n; i++)
        {
            int shift = nums[i] % n; // normalize whole array
            int newIndex= (i + shift) % n;

            if(newIndex < 0)
            {
                newIndex += n;
            }
            res[i]= nums[newIndex];
        }      
        return res;  
    }
}