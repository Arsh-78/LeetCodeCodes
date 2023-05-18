class Solution {
    public int findCircleNum(int[][] isConnected) {
        int pNum = 0;
        int V = isConnected.length;
        boolean[] vis = new boolean[V];
        ArrayList<Integer> trav = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(vis,i,isConnected,trav);
                pNum++;
            
            }
                 
                    
            
        }
        
        return pNum;
        
    }
    public static void dfs(boolean[] vis,int node,int[][] adj,ArrayList<Integer> trav)
    {
        vis[node]=true;
        trav.add(node);
        
        for(int i=0;i<adj[node].length;i++)
        {
            if(adj[node][i]==1)
            {
                if(vis[i]==false)
                {
                    dfs(vis,i,adj,trav);
                }
            }
        }
        
    }
}