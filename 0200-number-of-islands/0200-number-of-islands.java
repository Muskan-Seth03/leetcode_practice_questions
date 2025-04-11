class Pair   // using bfs to keep track of starting node and visi array to keep track of nodes visited 
{
    int first;
    int second;
    Pair(int first, int second)
    {
        this.first= first;
        this.second= second;
    }
    
}
class Solution {
    public static void  bfs(int i, int j, int [][]visi, char[][]grid)
    {
        int m= grid.length;
        int n= grid[0].length;
        visi[i][j]=1;
        Queue<Pair> q= new LinkedList<Pair>();
        q.offer(new Pair(i, j));

        while(!q.isEmpty())
        {
            Pair it= q.poll();
            int row= it.first;
            int col= it.second;

            int dir_r[] = {-1, 0, 1, 0};
            int dir_c[]= {0, 1, 0, -1};
            for(int k=0; k<4; k++)
            {
                int new_row= row + dir_r[k];
                int new_col= col + dir_c[k];

    if(new_row>=0 && new_row<m && new_col>=0 && new_col<n && grid[new_row][new_col] =='1' && visi[new_row][new_col]==0)
                {
                    visi[new_row][new_col]=1;
                    q.offer(new Pair(new_row, new_col));
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
                    bfs(i, j, visi, grid);
                }
            }
        }
        return count;
    }
}