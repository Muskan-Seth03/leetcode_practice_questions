class Solution {
    public void setZeroes(int[][] matrix) {
        int rows= matrix.length;
        int cols= matrix[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        // Store initial position of all zeroes in the matrix
        for(int i=0; i< rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(matrix[i][j]==0)
                queue.add(new int[]{i, j});
            }
        }

        while(!queue.isEmpty())
        {
            int [] cell= queue.poll();
            int r = cell[0];
            int c = cell[1];
            for(int j=0; j<cols; j++)  // in a particular row
            {
                matrix[r][j]=0;
            }
            for(int i=0; i< rows; i++)  // in a particular col
            {
                matrix[i][c]=0;
            }

        }

    }
}