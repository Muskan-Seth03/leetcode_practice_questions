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
    public int removeStones(int[][] stones) {
        int maxRow= 0;
        int maxCol=0;
        for(int[] stone: stones)
        {
            maxRow= Math.max(maxRow, stone[0]);
            maxCol= Math.max(maxCol, stone[1]);            
        }
        DisjointSet ds= new DisjointSet(maxRow + maxCol + 2);  // to avoid array out of bound situation
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int[] stone: stones)
        {
            int row= stone[0];
            int col= stone[1] + maxRow + 1;
            ds.unionByRank(row, col);           
            map.put(row, 1);
            map.put(col, 1);
        }

        int count=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(ds.findUParent(entry.getKey()) == entry.getKey())
            count++;
        }
        return stones.length - count;
    }
}

