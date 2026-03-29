// TC: O(n * n)  SC: O(n * n)
class Solution {
    public int[][] generateMatrix(int n) {
        int startRow = 0;
        int endRow = n-1;

        int startCol = 0;
        int endCol = n-1;

        int val = 1;
        int[][] grid= new int[n][n];

        while(startRow <= endRow && startCol <= endCol)
        {
            for(int col = startCol; col <= endCol; col++)
            {
                grid[startRow][col] = val;
                val++;
            }
            startRow++;

            for(int row = startRow; row <= endRow; row++)
            {
                grid[row][endCol] = val;
                val++;
            }
            endCol--;
            
            for(int col = endCol; col >= startCol; col--)
            {
                grid[endRow][col] = val;
                val++;
            }
            endRow--;

            for(int row = endRow; row >= startRow; row--)
            {
                grid[row][startCol] = val;
                val++;
            }
            startCol++;
        }
        return grid;
    }
}