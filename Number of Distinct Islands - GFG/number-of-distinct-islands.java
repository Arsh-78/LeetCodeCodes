//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        ArrayList<String> lands = new ArrayList<String>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        HashSet<String> st = new HashSet<>(); 
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(!vis[i][j] && grid[i][j]==1)
                {
                    String t= dfs(i,j,grid,vis,"",i,j);
                   //System.out.println(t);
                    st.add(t);
                }
            }
        }
        
        return st.size();
        
        
    }
    
    
    
    String toString(int r,int c)
    {
        String temp = Integer.toString(r)+Integer.toString(c) +" "; 
        return temp;
    }
    
    String dfs(int r,int c,int[][] grid,boolean[][] vis,String temp,int sr,int sc)
    {
        if( vis[r][c]==true)
        {
            return temp;
        }
        else
        {
            vis[r][c]=true;
            temp+= toString(r-sr,c-sc);
            
            
                                    
            if(isValid(r,c+1,grid))
                if(!vis[r][c+1] && grid[r][c+1]==1)
                    temp=dfs(r,c+1,grid,vis,temp,sr,sc);
                    

            
            if(isValid(r+1,c,grid))
                if(!vis[r+1][c] && grid[r+1][c]==1)
                   temp= dfs(r+1,c,grid,vis,temp,sr,sc);
                    
                    
                                
            if(isValid(r,c-1,grid))
                if(!vis[r][c-1] && grid[r][c-1]==1)
                   temp= dfs(r,c-1,grid,vis,temp,sr,sc);
                                
            if(isValid(r-1,c,grid))
                if(!vis[r-1][c] && grid[r-1][c]==1)
                    temp=dfs(r-1,c,grid,vis,temp,sr,sc);
                    
                    
            //System.out.println(temp);        
            return temp;
            
        }
    }
    
    boolean isValid(int r,int c,int[][] grid)
    {
        if(c<0 || r<0 || r>=grid.length || c>=grid[0].length)
        {
            return false;
        }
        return true;
    }
}
