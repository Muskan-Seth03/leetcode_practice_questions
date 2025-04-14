class Solution {   // recursive dfs   TC:O(m*n)  SC:O(m*n)
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int perimeter=0;
        int count=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter= dfs(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private static int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        int perimeter=0;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i] [j] == 0) {
            return  1;
        }

        if(grid[i][j]==-1)
        return 0;   // already visited , no perimeter contribution

        grid[i][j]=-1;

        perimeter+=dfs(grid, i, j-1);
        perimeter+=dfs(grid, i-1, j);
        perimeter+=dfs(grid, i, j+1);
        perimeter+=dfs(grid, i+1, j);

         return perimeter;
}
    }
   
