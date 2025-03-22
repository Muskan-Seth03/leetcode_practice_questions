class Solution {
    public void dfs(int [][] graph, List<List<Integer>> ans, List<Integer> path, int node )
    {

        //reached target node 
        if(node == graph.length - 1)
        {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int nextNode :graph[node])
        {
            path.add(nextNode);
            dfs(graph, ans, path, nextNode );
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n= graph.length;
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> path= new ArrayList<>();
        path.add(0);
        dfs(graph, ans, path, 0);
        return ans;
    }



}