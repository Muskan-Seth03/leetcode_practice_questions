class Solution {   //iterative dfs
    public  void  dfs(int  row, int col, char[][]board, int[][]visi, int dr[], int dc[])
    {
        int m= board.length;
        int n= board[0].length;
        visi[row][col]=1;
       
        for(int k=0; k<4; k++)
        {
            int new_r= row + dr[k];
            int new_c= col + dc[k];

    if(new_r>=0 && new_r<m && new_c>=0 && new_c<n && board[new_r][new_c]=='O' && visi[new_r][new_c]==0)
            {
                dfs(new_r, new_c, board, visi, dr, dc);
            }
        }

    }
    public void solve(char[][] board) {
        int m= board.length;
        int n= board[0].length;
        int visi[][]= new int[m][n];
        
        int dr[]={0, -1, 0, 1};
        int dc[]={-1, 0, 1, 0};


        for(int i=0; i<m; i++)
        {
            // first col
            if(board[i][0]=='O' && visi[i][0]==0)
            {
                dfs(i, 0, board, visi, dr,  dc);
            }
            // last  col
            if(board[i][n-1]=='O' && visi[i][n-1]==0)
            {
                dfs(i, n-1, board, visi, dr, dc);
            }
        }
        
        for(int j=0; j<n; j++)
        {
            // first row
            if(board[0][j]=='O' && visi[0][j]==0)
            {
                dfs(0, j, board, visi, dr, dc);
            }
            // last row
            if(board[m-1][j]=='O' && visi[m-1][j]==0)
            {
                dfs(m-1, j, board, visi, dr, dc);
            }
        }

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(board[i][j]=='O' && visi[i][j]==0)
                {
                    board[i][j]='X';
                }
            }
        }
    }
}