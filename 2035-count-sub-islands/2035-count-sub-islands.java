class Solution { // recursive dfs + in-place grid2 marking
                 // TC: O(m * n), SC: O(m * n) (recursion stack)
    public static int dfs(int r, int c, int [][]grid1, int[][]grid2)
    {
        int m= grid1.length;
        int n= grid1[0].length;

        if(r<0 || r>=m || c<0 || c>=n || grid2[r][c]==0)
        return 1;
        
        // Mark as visited in grid2
        grid2[r][c] = 0;

        // Check current cell validity in grid1
        int isValid = (grid1[r][c] == 1) ? 1 : 0;

        // Explore 4 directions
        int up = dfs(r - 1, c, grid1, grid2);
        int down = dfs(r + 1, c, grid1, grid2);
        int left = dfs(r, c - 1, grid1, grid2);
        int right = dfs(r, c + 1, grid1, grid2);

        // All neighbors must also be valid sub-island
        return isValid & up & down & left & right;
    }
                
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m= grid1.length;
        int n= grid1[0].length;
        int count=0;
       
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid2[i][j]==1)  // land cell
                {
                    count+= dfs(i, j, grid1, grid2);  
                }
            }
        }
        return count;
    }
}