class Solution {
    public static void dfs(int i, int []visi, int [][]isConnected)
    {
        int n= isConnected.length;
        visi[i]=1;
        for(int j=0; j< n; j++)
        {
            if(isConnected[i][j]==1  && visi[j]==0)
            {
                dfs(j,  visi, isConnected);
            }
        }

    }  
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int   count=0;
        int[]  visi= new int[n];
        Arrays.fill(visi, 0);

        for(int i=0; i<n; i++)
        {
            if(visi[i]==0)
            {
                count++;
                dfs(i, visi, isConnected);
            }
        }
        return count;        
    }
}