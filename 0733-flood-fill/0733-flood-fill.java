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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m= image.length;
        int n= image[0].length;

        int orig_color= image[sr][sc];
        if(image[sr][sc]== color)
        return image;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(sr,sc));
        while(!q.isEmpty())
        {
            Pair it= q.poll();
            int r= it.row;
            int c= it.col;

            int dr[]={-1,0,1,0};
            int dc[]= {0,1,0,-1};

            for(int i=0; i<4; i++)
            {
                int new_r= r + dr[i];
                int new_c= c+ dc[i];

                if(new_r>=0 && new_r <m && new_c >=0 && new_c <n && image[new_r][new_c] == orig_color)
                {
                    q.offer(new Pair(new_r, new_c));
                }
            }

            image[r][c]=color;
        }

        return image; 
    }
}