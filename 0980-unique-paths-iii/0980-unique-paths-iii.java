// backtracking approach   TC: O(4*(m*n))  SC: O(m*n)
class Solution {
    int m, n;
    int nonObstacle;
    int res;

    public void backtrack(int i, int j, int count, int[][] grid)
    {
        // boundary check
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == -1)
        return;

        if(grid[i][j] == 2)
        {
            if(count == nonObstacle)
            {
                res++;
            }
            return;
        }

        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        
        grid[i][j] = -1;
        
        for(int[] dir : dirs)
        {
            int new_x = i + dir[0];
            int new_y = j + dir[1];
            backtrack(new_x, new_y, count+1, grid);
        }
        grid[i][j] = 0;
    }
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        res = 0;
        nonObstacle = 0;
        
        int start_x = 0, start_y = 0;
        // count non obstacle
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 0)
                {
                    nonObstacle++;
                }
                if(grid[i][j] == 1)
                {
                    start_x = i;
                    start_y = j;
                }
            }
        }
        nonObstacle += 1;
        backtrack(start_x, start_y, 0, grid);
        return res;
    }
}