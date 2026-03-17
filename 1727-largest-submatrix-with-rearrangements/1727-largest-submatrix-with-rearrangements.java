// M-2 Without modifying the input array
// TC: O(m * nlogn)   SC: O(m * n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int maxArea = 0;

        int[] prevRow = new int[n];
        for(int i=0; i<m; i++)
        {
            int[] currRow = matrix[i];
            for(int j=0; j<n; j++)
            {
                if(currRow[j] == 1 && i>0)
                {
                    currRow[j] += prevRow[j];
                } 
            }
            // sort the row in desc order
            
            int[] heights = currRow.clone();   // copy the array otherwise heights will contain the reference and orig array will get sorted
            Arrays.sort(heights); // ascending

            // reverse array
            for(int k = 0; k < heights.length / 2; k++) {
                int temp = heights[k];
                heights[k] = heights[heights.length - 1 - k];
                heights[heights.length - 1 - k] = temp;
            }

            for(int ind=0; ind < heights.length; ind++)
            {
                int base = ind+1;
                int height = heights[ind];
                maxArea= Math.max(maxArea, base * height);
            }
            prevRow = currRow;
        }
        return maxArea;
    }
}