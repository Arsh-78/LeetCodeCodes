class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] isSafe = new boolean[graph.length];
        
        boolean[] vis =new boolean[graph.length];  
        int[] pathVis =new int[graph.length];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(graph[i].length==0)
            {
                isSafe[i]=true;
                vis[i]=true;
                ans.add(i);
            }
            
        }
        for(int i=0;i<graph.length;i++)
        {
            if(!vis[i])
                isSafe[i]=dfs(i,graph,vis,pathVis,isSafe);
        }
        System.out.println(Arrays.toString(isSafe));
        for(int i=0;i<graph.length;i++)
        {
            if(isSafe[i] && !ans.contains(i))
            {
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;

    }

    public boolean dfs(int node,int[][] graph,boolean[] vis,int[] pathVis,boolean[] isSafe)
    {
        if(vis[node] && isSafe[node])
        {
            return true;
        }
        else if(vis[node] && !isSafe[node])
        {
            return false;
        }
        else
        {
            vis[node]=true;
            pathVis[node]= 1;
            isSafe[node]=true;
            for(int i :graph[node])
            {
                if(!vis[i])
                {
                     if(!dfs(i,graph,vis,pathVis,isSafe))
                     {
                         isSafe[i]=false;
                         isSafe[node]=false;
                     }
                     

                }
                else if( pathVis[i]==1)
                {
                    isSafe[i]=false;
                    isSafe[node]=false;
                }
                else 
                {
                    isSafe[node]= isSafe[node] && isSafe[i];
                }
                
            }
            pathVis[node]=0;
            return isSafe[node];
        }
    }
}