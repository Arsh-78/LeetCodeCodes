//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Solution {
    class Pair{
        // p : parent adjacent node
        // n : actual current node
        int p,n;
        Pair(int n,int p){
            this.p = p;
            this.n = n;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i =0 ;i<vis.length;i++)
        {
            if(vis[i]==false)
            {
            if(dCycle(i,vis,adj))
            {
                return true;
            }
            }
        }
        return false;
    }
    
    public boolean dCycle(int src,boolean[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        
        Queue< Pair > q = new LinkedList<>();
        
        q.offer(new Pair(src,-1));
        vis[src]=true;
        
        while(!q.isEmpty())
        {
            int node = q.peek().n;
            int pNode = q.peek().p;
            q.remove();
            
            for(int adjNode : adj.get(node))
            {
                if(vis[adjNode]==false)
                {
                    vis[adjNode]=true;
                    q.offer(new Pair(adjNode,node));
                }
                else if(pNode != adjNode)
                {
                    return true;
                }
            }
        }
        return false;
    }
}