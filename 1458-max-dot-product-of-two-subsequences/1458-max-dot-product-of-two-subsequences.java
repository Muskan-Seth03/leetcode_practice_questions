// space optimisation
// TC: O(m * n)  SC: O(min(m, n))
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        int prev[]= new int[n];
        int curr[]= new int[n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                int product= nums1[i] * nums2[j];
                curr[j]= product;

                if(i>0 && j>0)
                {
                    curr[j]= Math.max(curr[j], product + Math.max(0, prev[j-1]));
                }
                if(i > 0)
                {
                    curr[j]= Math.max(curr[j], prev[j]);
                }
                if(j > 0)
                {
                    curr[j]= Math.max(curr[j], curr[j-1]);
                }
            }
            prev= curr.clone();
        }
        return prev[n-1];
    }
}