// using dfs
// using dfs
// TC: O(V+E)  SC: O(V+E)
class Solution {
    private boolean hasCycle;
    private Stack<Integer> s;

    private void isDFSCycle(int node, List<List<Integer>> adjList, int[]visi, int[]inRecursion)
    {
        visi[node]=1;  // visit node
        inRecursion[node]= 1;
        
        for(int adjNode : adjList.get(node))
        {
            if(inRecursion[adjNode]==1)
            {
                hasCycle= true;
                return;
            }
            // if not visited
            if(visi[adjNode]==0)
            {
                isDFSCycle(adjNode, adjList, visi, inRecursion);
                if(hasCycle)
                return;
            }
        }
              
        
        inRecursion[node]= 0;
        s.push(node);   
             
    }

    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList= new ArrayList<>();
        
        for(int i=0; i< numCourses; i++)
        {
            adjList.add(new ArrayList<>());
        }
        
        for(int []prerequisite : prerequisites)
        {
            int u=  prerequisite[0];
            int v=  prerequisite[1];
            
            adjList.get(v).add(u);
        }
        
        // apply dfs
        int visi[]= new int[numCourses];
        int []inRecursion= new int[numCourses];

        s= new Stack<>();

        for(int i=0; i< numCourses; i++)
        {
            if(visi[i]==0)
            {
                isDFSCycle(i, adjList, visi, inRecursion);
            }
        }

        if(hasCycle== true)
        return new int[0];      

        int[]res= new int[numCourses];
        int ind=0;
        while(!s.isEmpty())
        {
            res[ind++]= s.pop();
        }
        return res;
    }
}

    