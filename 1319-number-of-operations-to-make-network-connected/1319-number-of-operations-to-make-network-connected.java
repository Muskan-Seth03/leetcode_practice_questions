// TC: O(n) SC: O(n)
class Solution {
    public int find(int i, int parent[]){
        if(parent[i] == i)
        return i;
        
        return parent[i] = find(parent[i], parent);
    }
    public void union(int u, int v, int []parent, int[] rank){
       
        int u_par= find(u, parent);
        int v_par= find(v, parent);
        
        if(u_par == v_par)
        return ;
        
        if(rank[u_par] >  rank[v_par])
        {
            parent[v_par]= u_par;
        }
        else if (rank[v_par] > rank[u_par])
        {
            parent[u_par]= v_par;
        }
        else
        {
            parent[u_par]= v_par;
            rank[v_par] += 1;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int parent[] = new int[n];
        int rank[]= new int[n];
        
        for(int i=0; i<n; i++)
        {
            parent[i]= i;
        }

        int freeEdge=0;
        int []visi= new int[n];

        for(int[] connection: connections)
        {
            int u= connection[0];
            int v= connection[1];

            int u_par= find(u, parent);
            int v_par= find(v, parent);

            if(u_par == v_par)
            {
                // no need to use that edge ... free edge
                freeEdge++;
            }
            else
            {
                visi[u]=1;
                visi[v]=1;
                union(u, v, parent, rank);
            }
        }
        int isolatedNode=0;
        for(int i=0; i<n; i++)
        {
            if(visi[i] == 0)
            {
                isolatedNode++;
            }
        }

        if(freeEdge >= isolatedNode)
        return isolatedNode;
        else
        return -1;
       
    }
}