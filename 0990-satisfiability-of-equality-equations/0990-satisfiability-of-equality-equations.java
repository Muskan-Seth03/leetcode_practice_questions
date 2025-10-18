// TC: O(1) SC: O(1)
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
            rank[v_par]+=1;
        }
    }
    public boolean equationsPossible(String[] equations) {

        int parent[] = new int[26];
        int rank[]= new int[26];
        
        for(int i=0; i<26; i++)
        {
            parent[i]= i;
        }
        
        for(String eq : equations)
        {
           if(eq.charAt(1) == '=')
            {
                int u = eq.charAt(0) - 'a';
                int v= eq.charAt(3) - 'a';
                union(u, v, parent, rank);
            }
        }

        // Step 2: Check all "!=" equations for conflict
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                if (find(u, parent) == find(v, parent)) {
                    return false; // Conflict found
                }
            }
        }

        return true; // All equations satisfied
    }
}