//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] sp = new int[n];
        for(int i=0;i<sp.length;i++)
        {
            sp[i]=Integer.MAX_VALUE;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        sp[src]=0;
        
        while(!q.isEmpty())
        {
            int p=q.peek();
            int d=sp[p];
            q.remove();
            
            for(int adjNode : adj.get(p))
            {
                if(sp[adjNode] > d+1)
                {
                    sp[adjNode]=d+1;
                    q.add(adjNode);
                }
            }
        }
        for(int i=0;i<sp.length;i++)
        {
            if(sp[i]==Integer.MAX_VALUE)
                sp[i]=-1;
        }
        return sp;
    }
}