class Pair{       // using bfs
    int row;
    int col;
    Pair(int row, int col)
    {
        this.row= row;
        this.col= col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        
        int count=0;  // count the no of fresh oranges pushed into the queue
        int fresh_count=0;  // count the no of fresh oranges present initially
        for(int i=0; i<m ;i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==2)
                {        
                    q.offer(new Pair(i,j));
                }
                if (grid[i][j]!=0) // value is 1
                {
                    fresh_count++;
                }
            }
        }

            int timer=0;
            if(fresh_count==0)
            return 0;

            int dr[]={-1,0,1,0};
            int dc[]= {0,1,0,-1};
            while(!q.isEmpty())
            {
                int size= q.size();
                count+= size;
                for(int k=0; k<size; k++)
                {
                    Pair it= q.poll();
                    int r= it.row;
                    int c= it.col;

                    for(int i=0; i<4; i++)
                    {
                        int new_r= r + dr[i];
                        int new_c= c+ dc[i];

                        if(new_r>=0 && new_r <m && new_c>=0 && new_c<n && grid[new_r][new_c]==1)
                        {
                            grid[new_r][new_c]=2;
                            q.offer(new Pair(new_r, new_c));
                        }
                    }
                }
                if(q.size()!=0)
                timer++;
            }
            return fresh_count==count? timer: -1;

        }
}

        
