class Solution {  //brute force approach 
    public static boolean dfs(int ind, int i, int j, int row, int col, char[][]board, String word)
    {
        //base case
        if(ind ==word.length())
        return true;

        if(i<0 || j<0 || i==row || j==col || board[i][j]!= word.charAt(ind))
        return false;

        char x= board[i][j];
        board[i][j]= '*';

        int rdir[]={0, 1, 0,-1};
        int cdir[]={1, 0, -1, 0};

        for(int d=0; d<4; d++)
        {
            if(dfs(ind+1, i + rdir[d], j + cdir[d], row, col, board, word)==true)
            return true;
        }
        board[i][j]= x;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int row= board.length;
        int col= board[0].length;
        for(int i= 0; i< row; i++)
        {
            for(int j=0; j< col; j++)
            {
                if(dfs(0, i, j, row, col, board, word) == true)
                return true;

            }
        }
        return false;
    }
}