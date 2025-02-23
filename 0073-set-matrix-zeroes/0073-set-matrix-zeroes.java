//mark the indices in row[i] arr and cols[j] arr for {i, j} wherever we encounter 0   
class Solution {  //better approach using 2 array            
    public void setZeroes(int[][] matrix) {
        int rows= matrix.length;
        int cols= matrix[0].length;

        int row_array[]= new int [rows];
        int cols_array[]= new int [cols];
       
       for(int i=0; i<rows; i++)
       {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j]==0)
                {
                    // mark the ith index of row_array to 1
                    row_array[i]=1;
                    cols_array[j]=1;
                }
            }
        }
        for(int i=0; i<rows; i++)
       {
            for(int j=0; j<cols; j++)
            {
                if(row_array[i]==1 ||  cols_array[j]==1)
                {
                    matrix[i][j]=0;
                }

            }
        }
        
    }
}