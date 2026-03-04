class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;

        int result = 0;
        int[] rowOneCount = new int[m];
        int[] colOneCount = new int[n];

        int[] rowZeroCount = new int[m];
        int[] colZeroCount = new int[n];

        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                if(grid[row][col] == 1)
                {
                    rowOneCount[row] += 1;
                    colOneCount[col] += 1;
                }
                else //if(grid[row][col] == 0)
                {
                    rowZeroCount[row] += 1;
                    colZeroCount[col] += 1; 
                }
            }
        }
        int[][] diffMat = new int[m][n];
        for(int row = 0; row < m; row++)
        {
            for(int col = 0; col < n; col++)
            {
                int diff = rowOneCount[row] + colOneCount[col] - rowZeroCount[row] - colZeroCount[col]; 
                diffMat[row][col] = diff; 
            }
        } 
        return diffMat;
    }
}