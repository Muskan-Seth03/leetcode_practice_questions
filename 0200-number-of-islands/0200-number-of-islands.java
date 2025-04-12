class Solution {  //  using dfs TC:O()  SC:O(m*n)
    public static void  dfs(int i, int j, int [][]visi, char[][]grid)
    {
        int m= grid.length;
        int n= grid[0].length;
        visi[i][j]=1;
        grid[i][j]=0;
        Stack<int[]> s= new Stack<>();
        s.push(new int[]{i,j});

        while(!s.isEmpty())
        {
            int []it= s.pop();
            int row= it[0];
            int col= it[1];

            int dir_r[] = {-1, 0, 1, 0};
            int dir_c[]= {0, 1, 0, -1};
            for(int k=0; k<4; k++)
            {
                int new_row= row + dir_r[k];
                int new_col= col + dir_c[k];

    if(new_row>=0 && new_row<m && new_col>=0 && new_col<n && grid[new_row][new_col] =='1' && visi[new_row][new_col]==0)
                {
                    visi[new_row][new_col]=1;
                    s.push(new int[]{new_row, new_col});
                }
            }
        }
    }


    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int visi[][]= new int[m][n];
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                visi[i][j]= 0;
            }
        }
        int count=0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(visi[i][j]==0 && grid[i][j]=='1')
                {
                    count++;
                    dfs(i, j, visi, grid);
                }
            }
        }
        return count;
    }
}