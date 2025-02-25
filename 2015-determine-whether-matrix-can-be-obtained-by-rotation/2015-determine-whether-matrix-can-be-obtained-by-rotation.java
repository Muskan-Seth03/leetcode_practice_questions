class Solution {  //optimal approach TC: O(3* n^2) SC: O(1)
    public void rotate(int[][] mat) {
        int n= mat.length;
        // taking transpose ( putting element in the position of its transpose)  
        for(int i=0; i<n; i++)
        {
            for(int j=i; j< n; j++)
            {
                int temp= mat[i][j];
                mat[i][j]= mat[j][i];
                mat[j][i]= temp;
            }
        }
        // reverse the transpose matrix
        for(int i=0; i<n; i++)
        {
            for( int j=0; j<n/2; j++)
            {
                int temp= mat[i][j];
                mat[i][j]= mat[i][n-j-1];
                mat[i][n-j-1]= temp;
            }
        }
        

    }
    public boolean isEqual(int[][] mat, int[][] target) {
        int n= mat.length;
        // check if rotated matrix is equal to target matrix
        for(int i=0; i<n; i++)
        {
            for(int j=0; j< n; j++)
            {
                if(mat[i][j]!= target[i][j])
                {
                    return false;
                }

            }
        }
        return true;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n= mat.length;
        // max rotation possible ===>3

        for(int i=0; i<4; i++)
        {
            if(isEqual(mat, target))
            return true;
            else
            rotate(mat);
        }
        return false;
    }
    
}