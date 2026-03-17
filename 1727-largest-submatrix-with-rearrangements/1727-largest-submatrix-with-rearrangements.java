// M-1 Modifying the input array
// TC: O(m * nlogn)   SC: O(m * n)
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m= matrix.length;
        int n= matrix[0].length;
        int maxArea = 0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] == 1 && i>0)
                {
                    matrix[i][j] += matrix[i-1][j];
                } 
            }
            // sort the row in desc order
            
            int[] heights = matrix[i].clone();   // copy the array otherwise heights will contain the reference and orig array will get sorted
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
        }
        return maxArea;
    }
}