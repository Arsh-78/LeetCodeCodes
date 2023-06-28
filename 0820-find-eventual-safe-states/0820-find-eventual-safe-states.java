class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] isSafe = new boolean[graph.length];
        
        boolean[] vis =new boolean[graph.length];  
        
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
                isSafe[i]=dfs(i,graph,vis,isSafe);
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

    public boolean dfs(int node,int[][] graph,boolean[] vis,boolean[] isSafe)
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
            boolean res = true;
            for(int i : graph[node])
                res=res&&dfs(i,graph,vis,isSafe);
            isSafe[node]=res;
            return res;    
          
        }
    }
}