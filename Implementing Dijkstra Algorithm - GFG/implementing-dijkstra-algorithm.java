//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Pair{
        int dist;
        int node;
        Pair(int node,int dist)
        {
            this.node=node;
            this.dist=dist;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] sd = new int[V];

        PriorityQueue<Pair> q  = new PriorityQueue<Pair>((x,y)->x.dist-y.dist);
        
        
        q.add(new Pair(S,0));
        
        for(int i=0;i<V;i++)
        {
            sd[i]=(int)1e9;
        }
                sd[S]=0;
        
        while(!q.isEmpty())
        {
            Pair v=q.peek();
            q.remove();
            for(int i=0;i<adj.get(v.node).size();i++)
            {
                int n = adj.get(v.node).get(i).get(0);
                int wt =adj.get(v.node).get(i).get(1);
                
                if(sd[n]>v.dist+wt)
                {
                    sd[n]=v.dist+wt;
                    q.add(new Pair(n,sd[n]));
                }
                
            }
        }
        for(int i=0;i<V;i++)
        {
            if(sd[i]==1e9)
            {
                sd[i]=-1;
            }
        }
        return sd;
        
    }
}

