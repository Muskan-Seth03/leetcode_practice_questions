class Solution {   // using dfs
    public void dfs(int sr, int sc, int[][] image, int color, int orig_color)
    {
        int m= image.length;
        int n= image[0].length;
        image[sr][sc]=color;
        int dr[]={-1,0,1,0};
        int dc[]= {0,1,0,-1};
        
        for(int i=0; i<4; i++)
        {
            int new_r= sr + dr[i];
            int new_c= sc+ dc[i];
            
            if(new_r>=0 && new_r <m && new_c >=0 && new_c <n && image[new_r][new_c] == orig_color)
                {
                    dfs(new_r, new_c, image, color, orig_color);
                }
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m= image.length;
        int n= image[0].length;

        if(image[sr][sc]== color)
        return image;
        int orig_color= image[sr][sc];
        
        dfs(sr, sc, image, color, orig_color);

        return image; 
    }
}