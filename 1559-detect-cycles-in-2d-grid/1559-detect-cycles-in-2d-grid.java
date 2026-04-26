// TC: O(m*n)   SC: O(m*n)
class Solution {
    public boolean dfs(int i, int j, int prev_i, int prev_j, char[][] grid, boolean[][] visi)
    {
        int m = grid.length;
        int n = grid[0].length;
        if(visi[i][j] == true)
        {
            return true;
        }
        visi[i][j] = true;

        // four directions
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int[] dir: dirs)
        {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            // boundary conditions
            if(new_i >=0 && new_i <m && new_j >=0 && new_j <n && grid[i][j] == grid[new_i][new_j])
            {
                // call dfs on one direction, if we can find answer from that direction, then return true     

                if(new_i == prev_i && new_j == prev_j) 
                continue;   
   
                if(dfs(new_i, new_j, i, j, grid, visi))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visi = new boolean[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j =0; j<n; j++)
            {
                if(!visi[i][j] && dfs(i, j, i, j, grid, visi))
                {
                    return true;
                }
            }
        } 
        return false;
    }
}