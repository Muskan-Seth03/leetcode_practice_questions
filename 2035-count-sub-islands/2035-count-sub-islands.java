class Solution {   //dfs + stack + visi
                   //TC:O(m*n)   SC:O(m*n) 

    public static int dfs(int row, int col, int [][]grid1, int[][]grid2, int[][]visi)
    {
        int m= grid1.length;
        int n= grid1[0].length;
        Stack<int[]> s= new Stack<>();

        int count=1;
        s.push(new int[]{row, col});
        
        int dr[]={-1,0,1,0};
        int dc[]= {0,1,0,-1};
        
        while(!s.isEmpty())
        {
            int [] it= s.pop();
            int r= it[0];
            int c= it[1];

            if(grid1[r][c]!=1) 
            count=0;

            for(int i=0; i<4; i++)
            {
                int new_r= r+ dr[i];
                int new_c= c + dc[i];

                if(new_r>=0 && new_r<m && new_c>=0 && new_c< n && grid2[new_r][new_c]==1 && visi[new_r][new_c]==0)
                {
                    visi[new_r][new_c]=1;  // visit that cell 
                    s.push(new int[]{new_r, new_c});
                }
            }
        }

        return count;
    }
                
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m= grid1.length;
        int n= grid1[0].length;

        int count=0;
        int [][]visi= new int[m][n];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(visi[i][j]==0 && grid2[i][j]==1)  // not visited + land cell
                {
                    visi[i][j]=1;
                    if(grid2[i][j]==1)
                    {
                        count+= dfs(i, j, grid1, grid2, visi);
                    }
                }
            }
        }
        return count;
    }
}