class Solution {
    public int solve(int i, int j, int m, int n, int[][]grid)
    {
        // base case
        if(i== m-1 && j == n-1)
        return grid[i][j];

        if(i == m-1) // last row
        {
            return grid[i][j] + solve(i, j+1, m, n, grid);
        }
        else if(j == n-1)
        {
            return grid[i][j] + solve(i+1, j, m, n, grid);
        }
        else
        {
        return grid[i][j] + Math.min(solve(i, j+1, m, n, grid), solve(i+1, j, m, n, grid));
        }
    }

    public int minPathSum(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        return solve(0, 0, m, n, grid);       
    }
}