//brute force   TC: O(2N)  SC: O(N) + O(N)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int res[]= new int[n];

        for(int i=0; i< n; i++)
        {
            int val= nums1[i];

            int index=0;
            for(int j=0; j< nums2.length; j++)
            {
                if( nums2[j]== val)
                {
                    index= j;
                    break;
                }
            }

            int nextGreater=-1;
            for(int k = index + 1; k < nums2.length; k++)
            {
                if( nums2[k]> val)
                {
                    nextGreater = nums2[k];
                    break; 
                }
            }
            res[i] = nextGreater;
        }
        return res;        
    }
}