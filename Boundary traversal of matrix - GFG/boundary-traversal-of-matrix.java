//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        // code here 
        int[][] dirs ={ {0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++)
            Arrays.fill(vis[i],false);
        ArrayList<Integer> ans = new ArrayList<>();
        int r=0;
        int c=0;
        ans.add(matrix[0][0]);
        vis[0][0]=true;
        for(int i=0;i<dirs.length;i++)
        {
            while(r+dirs[i][0]<n && r+dirs[i][0]>=0 && c+dirs[i][1]<m && c+dirs[i][1]>=0)
            {
                r=r+dirs[i][0];
                c=c+dirs[i][1];
                if(vis[r][c]==false)
                {
                    ans.add(matrix[r][c]);
                    vis[r][c]=true;
                }
            }
            
            
        }
        
        return ans;
    }
}
