class Solution { //dfs + stack (no visi array --in place change of visited land cell to water )
                //TC:O(m*n)   SC:O(m*n) 

    public static int dfs(int row, int col, int [][]grid1, int[][]grid2)
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

                if(new_r>=0 && new_r<m && new_c>=0 && new_c< n && grid2[new_r][new_c]==1)
                {
                    grid2[new_r][new_c]=0;  // visit that cell 
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
       
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid2[i][j]==1)  // land cell
                {
                    grid2[i][j]=0;
                    count+= dfs(i, j, grid1, grid2);  
                }
            }
        }
        return count;
    }
}