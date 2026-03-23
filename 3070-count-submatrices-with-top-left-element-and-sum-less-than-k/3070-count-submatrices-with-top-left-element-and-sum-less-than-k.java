// TC: O(m * n)  SC: O(1)
class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        int m= grid.length;
        int n= grid[0].length;
        for(int i =0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                grid[i][j] += (i<1) ? 0 : grid[i-1][j];
                grid[i][j] += (j<1) ? 0 : grid[i][j-1];
                grid[i][j] -= (i<1 || j<1) ? 0 : grid[i-1][j-1];

                if(grid[i][j] <= k)
                {
                    count++;
                }
                else
                break;
            }
        }
        return count;
    }
}