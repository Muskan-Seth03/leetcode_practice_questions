import java.util.*;           // using bfs

class Solution {
    private int visi[];
    private ArrayList<ArrayList<Integer>> adjList; 
    
    private void bfs(int i)
    {
        visi[i]= 1;

        Queue<Integer> q= new LinkedList<>();
        q.offer(i);
        
        while(!q.isEmpty())
        {
            int node= q.poll();
            
            for(int adjNode : adjList.get(node))
            {
                if(visi[adjNode] == 0)
                {
                    visi[adjNode] = 1;
                  
                    q.offer(adjNode);
                }
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        adjList = new ArrayList<>();
  
        visi= new int[n];

       

        for(int i=0; i < n; i++)
        {
            adjList.add(new ArrayList<>());
        }
        
        for(int i=0; i < n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(isConnected[i][j] == 1)
                {
                    adjList.get(i).add(j);
                }
            }   
        }
        
        int connectedComp = 0;
        for(int i=0; i<n; i++)
        {
           
            if(visi[i]==0)
            {
                connectedComp++;
                bfs(i);
            }
            
        }
        
        return connectedComp;        
    }
}