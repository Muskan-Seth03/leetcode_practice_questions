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
    public long countPairs(int n, int[][] edges) {
        int parent[] = new int[n];
        int rank[]= new int[n];
        
        for(int i=0; i<n; i++)
        {
            parent[i]= i;
        }

        for(int edge[]: edges)
        {
            int u= edge[0];
            int v= edge[1];

            union(u, v, parent, rank);
        }
        // create map  key==> parent[i] --> count of component attached to it

        Map<Integer, Integer> map= new HashMap<>(); 
        for(int i=0; i<n; i++)
        {
            map.put(find(i, parent), map.getOrDefault(find(i, parent), 0) + 1);
        }

        long res = 0;
        long remaining = n;

        // Count unreachable pairs between components
        for (int size : map.values()) {
            res += (long) size * (remaining - size);
            remaining -= size;
        }

        return res;
    }
}