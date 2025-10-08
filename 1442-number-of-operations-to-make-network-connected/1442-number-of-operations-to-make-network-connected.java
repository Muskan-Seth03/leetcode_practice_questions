// DSU  TC: O(4alpha) SC:O()
import java.util.*;

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUParent(int node) {
        if (node == parent.get(node))
            return node;
        int ulp = findUParent(parent.get(node));
        parent.set(node, ulp); // path compression
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if (ulp_u == ulp_v) return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUParent(u);
        int ulp_v = findUParent(v);
        if (ulp_u == ulp_v) return;

        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds= new DisjointSet(n);
        int extraEdge=0;
        for (int i = 0; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            
            if (ds.findUParent(u) == ds.findUParent(v)) 
            {
                extraEdge++;
            }
            else
            ds.unionByRank(u,v);
        }
            
            int countC=0;
            for(int i=0; i<n;i++)
            {
                if(ds.parent.get(i)==i)
                {
                    countC++;
                }
            }
            int ans=countC - 1;
            if(extraEdge>=ans)
            return ans;
            else
            return -1;        
    }
}