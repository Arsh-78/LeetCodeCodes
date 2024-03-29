//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class Pair implements Comparable<Pair>
    {
        int node;
        int wt;
        Pair(int a,int b)
        {
            this.node=a;
            this.wt=b;
        }
        
        @Override
        public int compareTo(Pair p2)
        {
            return this.wt-p2.wt;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
	    
	    for(int i=0;i<V;i++)
	    {
	        adj.add(new ArrayList<>());
	        
	    }
	    
	    for(int i=0;i<E;i++)
	    {
	        adj.get(edges[i][0]).add(new int[]{edges[i][1],edges[i][2]});
	        adj.get(edges[i][1]).add(new int[]{edges[i][0],edges[i][2]});
	    }
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    boolean[] vis = new boolean[V];
	    pq.add(new Pair(0,0));
	    int sum=0;
	    
	    while(!pq.isEmpty())
	    {
	        int cNode = pq.peek().node;
	        int cW = pq.peek().wt;
	        pq.remove();
	        if(vis[cNode])
	        {
	            continue;
	        }
	        
	        vis[cNode]=true;
	        sum+=cW;
	        
	        for(int[] edge : adj.get(cNode))
	        {
	            if(!vis[edge[0]])
	            {
	                pq.add(new Pair(edge[0],edge[1]));
	            }
	        }
	   
	    }
	    return sum;
	    
	}
}