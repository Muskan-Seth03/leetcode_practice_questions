class Solution {
    public void dfs(int i , int [] visi, int[][] isConnected)
    {
        int n= isConnected.length;
        visi[i]=1;
        for(int it=0; it<n; it++)
        {
            if(visi[it]==0 && isConnected[i][it]==1)
            {
                dfs(it, visi, isConnected);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        int visi[]= new int [n];
        Arrays.fill(visi, 0);

        int count=0;
        for(int i=0; i<n; i++)
        {
            if(visi[i]==0){
             count++;
            dfs(i, visi, isConnected);
            }
           
        }
        return count;
        
    }
}