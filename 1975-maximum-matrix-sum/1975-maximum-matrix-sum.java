// TC: O(n * n)  SC: O(1)
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n= matrix.length;
        long sum= 0;
        long count=0;
        long mini= Long.MAX_VALUE;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(matrix[i][j] > 0)
                {
                    sum += matrix[i][j];
                }
                else
                {
                    sum += Math.abs(matrix[i][j]);
                    count++;
                }
                // compare mini with absolute value of cell
                mini= Math.min(mini, Math.abs(matrix[i][j]));  
            }
        }
        if(count % 2 == 0)
        {
            // even no of negative value 
            return sum;   // absolute sum is the max sum
        }
        
        sum -= (2 * mini);
        return sum;
    }
}