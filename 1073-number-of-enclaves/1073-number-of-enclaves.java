class Solution {
    public static void dfs(int  row, int col, int[][]grid, int[][]visi, int dr[], int dc[])
    {
        int m= grid.length;
        int n= grid[0].length;
        visi[row][col]=1;
        grid[row][col]= 0;
       
        for(int k=0; k<4; k++)
        {
            int new_r= row + dr[k];
            int new_c= col + dc[k];

    if(new_r>=0 && new_r<m && new_c>=0 && new_c<n && grid[new_r][new_c]==1 && visi[new_r][new_c]==0)
            {
                dfs(new_r, new_c, grid, visi, dr, dc);
            }
        }

      
    }

    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int visi[][]= new int[m][n];
        
        int dr[]={0, -1, 0, 1};
        int dc[]={-1, 0, 1, 0};


        for(int i=0; i<m; i++)
        {
            // first col
            if(grid[i][0]==1 && visi[i][0]==0)
            {
                dfs(i, 0, grid, visi, dr,  dc);
            }
            // last  col
            if(grid[i][n-1]==1 && visi[i][n-1]==0)
            {
                dfs(i, n-1, grid, visi, dr, dc);
            }
        }
        
        for(int j=0; j<n; j++)
        {
            // first row
            if(grid[0][j]==1 && visi[0][j]==0)
            {
                dfs(0, j, grid, visi, dr, dc);
            }
            // last row
            if(grid[m-1][j]==1 && visi[m-1][j]==0)
            {
                dfs(m-1, j, grid, visi, dr, dc);
            }
        }
        
        int enclaves=0;
            for(int i=0; i<m; i++)
            {
                for(int j=0; j<n; j++)
                {
                    if(grid[i][j]==1)
                    {
                        enclaves++;
                    }
                }
            }
            return enclaves;
        }
}