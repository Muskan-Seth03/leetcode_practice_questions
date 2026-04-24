// TC: O(n^2)  SC: O(n)

class Solution {
    public void dfs(int curr, int[][] isConnected, int[] visi)
    {
        int n = isConnected.length;
        visi[curr] = 1;

        for(int i=0; i<n; i++)
        {
            if(isConnected[curr][i] == 1 && curr != i && visi[i] == 0) 
            {
                dfs(i, isConnected, visi);
            } 
        }
        return;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visi = new int[n];
        int component = 0;
        for(int i=0; i<n; i++)
        {
            if(visi[i] == 0)
            {
                component++;
                dfs(i, isConnected, visi);
            }
        }
        return component;
    }
}