//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int mod = 1_000_000_007;
    static int uniquePaths(int n, int m, int[][] grid) {
        // code here
        if(grid[n-1][m-1] ==0 || grid[0][0]==0)
            return 0;
        boolean[][] vis = new boolean[n][m];
        long[][] dp = new long[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis[i],false);
            Arrays.fill(dp[i],-1);
        }
        return (int)(move(0,0,grid,vis,dp)%mod);
    }
    
    
    static long move(int r ,int c,int[][] grid ,boolean[][] vis,long[][] dp)
    {
        
        if(r==grid.length-1 && c==grid[0].length-1)
            return 1;
        
        
        if(dp[r][c] != -1)
        {
            return dp[r][c];
        }
        vis[r][c]=true;
        int[][] dirs = new int[][]{{0,1},{1,0}};
        long ways=0;
        for(int i=0;i<dirs.length;i++)
        {
            if(canMove(r+dirs[i][0],c+dirs[i][1],grid,vis))
            {
              ways=(ways+move(r+dirs[i][0],c+dirs[i][1],grid,vis,dp)%mod)%mod;  
            }
                
        }
        vis[r][c]=false;
        dp[r][c]=ways;
        return ways;
        
    }
    
    static boolean canMove(int r,int c,int[][] grid,boolean[][] vis)
    {
        if(r<0 || r>=grid.length ||c<0 ||c>=grid[0].length || grid[r][c]==0 || vis[r][c]==true)
        {
            return false;
        }
        return true;
    }
};