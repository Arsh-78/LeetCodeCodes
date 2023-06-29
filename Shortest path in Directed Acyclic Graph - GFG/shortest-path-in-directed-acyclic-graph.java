//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
    class Pair {
        int node;
        int dist;
        Pair(int node,int dist)
        {
            this.node=node;
            this.dist=dist;
        }
    }

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Stack<Integer> st = new Stack();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Pair>());
        }
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int[] sp = new int[n];
        boolean[] vis = new boolean[n];
        
        
        
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                topo(i,adj,vis,st);
            }
        }
        for(int i=0;i<n;i++)
        {
            sp[i]= (int)(1e9);
        }
        sp[0]=0;
        
        while(!st.isEmpty())
        {
            int c = st.peek();
            st.pop();
            
            for(int i=0;i<adj.get(c).size();i++)
            {
                int v=adj.get(c).get(i).node;
                int d = adj.get(c).get(i).dist;
                if(sp[v]>sp[c]+d)
                {
                    sp[v]=sp[c]+d;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(sp[i]==1e9)
            {
                sp[i]=-1;
            }
        }
        return sp;
	}
	
	public void topo(int n , ArrayList<ArrayList<Pair>> adj,boolean[] vis,Stack<Integer> st)
	{
	    vis[n]=true;
	    
	    for(int i=0 ;i<adj.get(n).size();i++)
	    {
	       if(!vis[adj.get(n).get(i).node])
	       {
	           topo(adj.get(n).get(i).node,adj,vis,st);
	       }
	    }
	    st.add(n);
	}
}


