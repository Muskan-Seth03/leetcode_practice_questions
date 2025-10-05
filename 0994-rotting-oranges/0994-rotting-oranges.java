class Pair{
    int a;
    int b;
    Pair(int a, int b)
    {
        this.a= a;
        this.b= b;
    }
}

class Solution {
    int []dx= {-1,0,1,0};
    int []dy= {0,1,0,-1};

    Queue<Pair> q;    

    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;
        int time=-1;
        q= new LinkedList<>();
        int fresh=0;
        // collect all rotten orange in queue
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.offer(new Pair(i, j));
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        if(fresh == 0)
        return 0;

        // apply bfs
        while(!q.isEmpty())
        {
            time++;
            int size= q.size();
           
            
            for (int p = 0; p < size; p++) 
            {
                Pair node = q.poll();
                int x= node.a;
                int y= node.b;
                for(int k=0; k<4; k++)
                {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 1)
                    {
                        grid[nx][ny] = 2; // rot the fresh orange 
                        fresh--; 
                        q.offer(new Pair(nx, ny));
                    }
                }

            }
        }
        return (fresh ==0)? time : -1;       

    }
}