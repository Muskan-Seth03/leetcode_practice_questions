class Solution { // optimal approach  TC: O(n^2) SC: O(1)
    public void rotate(int[][] matrix) {
        int n= matrix.length;
        // taking transpose ( putting element in the position of its transpose)
        for(int i=0; i<n; i++)
        {
            for(int j=i; j< n; j++)
            {
                int temp= matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        // reverse the transpose matrix
        for(int i=0; i<n; i++)
        {
            for( int j=0; j<n/2; j++)
            {
                int temp= matrix[i][j];
                matrix[i][j]= matrix[i][n-j-1];
                matrix[i][n-j-1]= temp;
            }
        }

    }
}
