//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int pNum = 0;
        boolean[] vis = new boolean[V];
        ArrayList<Integer> trav = new ArrayList<>();
        
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                dfs(vis,i,adj,trav);
                pNum++;
            
            }
                 
                    
            
        }
        
        return pNum;
        
    }
    
    public static void dfs(boolean[] vis,int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> trav)
    {
        vis[node]=true;
        trav.add(node);
        
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(adj.get(node).get(i)==1)
            {
                if(vis[i]==false)
                {
                    dfs(vis,i,adj,trav);
                }
            }
        }
        
    }
};