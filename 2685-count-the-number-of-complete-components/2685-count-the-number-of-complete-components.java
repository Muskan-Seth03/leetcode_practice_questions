// dsu approach
// TC: O(E * alpha(V))
class DSU
{
    int[] parent;
    int[] size;

    DSU(int n)
    {
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++)
        {
            parent[i] = i;
            size[i] = 1; 
        }
    }
    public int find(int x)
    {
        if(parent[x] == x)
        return x;

        return parent[x] = find(parent[x]);     // path compression
    }

    public void union(int x, int y)
    {
        int x_par = find(x);
        int y_par = find(y);

        if(x_par == y_par)
        return;

        if(size[x_par] > size[y_par])
        {
            parent[y_par] = x_par;
            size[x_par] += size[y_par]; 
        }
        else if(size[x_par] < size[y_par])
        { 
            parent[x_par] = y_par;
            size[y_par] += size[x_par]; 
        }
        else
        {
            parent[y_par] = x_par;
            size[x_par] += size[y_par]; 
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        Map<Integer, Integer> map = new HashMap<>();  // root -> edge

        for(int[] edge: edges)
        {
            int u = edge[0];
            int v = edge[1];

            dsu.union(u, v);       // alpha(V)
        }

        for(int[] edge: edges)
        {
            int root = dsu.find(edge[0]);
            map.put(root, map.getOrDefault(root, 0) + 1);
        }

        int res = 0; 
        for(int i=0; i<n; i++)
        {
            if(dsu.find(i) == i)
            {
                int v = dsu.size[i];
                int e = map.getOrDefault(i, 0);

                if((v * (v-1)/2) == e)
                res++; 
            }
        }
        return res;
    }
}