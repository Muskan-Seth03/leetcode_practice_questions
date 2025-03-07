class Solution {  // iterative dfs  TC:O(m*n)  SC:O(m*n)
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int max_area=0;
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    int area=dfs(grid, i, j);
                    max_area= Math.max(max_area, area);
                }
            }
        }

        if(count==0)  // no island present
        {
            return 0;
        }
        return max_area;
        
    }

    private static int dfs(int[][] grid, int i, int j) {

        int m = grid.length, n = grid[0].length;

        // boundary and water check 
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;   //mark it as visited
        int area=1;

        // check in all 4 directions
        area+= dfs(grid, i + 1, j);
        area+= dfs(grid, i - 1, j);
        area+= dfs(grid, i, j + 1);
        area+= dfs(grid, i, j - 1);

        return area;
    }
}
