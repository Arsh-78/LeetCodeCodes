//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean[][] vis = new boolean[n][n];
        
        ArrayList<String> ans  =  new ArrayList<String>();
        if(m[0][0]==0)
            return ans;
        helper(0,0,m,vis,"",ans);
        return ans;
        
    }
    public static void helper(int r,int c,int[][] m,boolean[][] vis, String p,ArrayList<String> ans)
    {
        if( r==m.length-1 && c==r )
        {
            ans.add(p);
            return;
        }
        vis[r][c]=true;
        
        if(isValid(r-1,c,m,vis))
        {
            helper(r-1,c,m,vis,p+'U',ans);
        }
        if(isValid(r,c+1,m,vis))
        {
            helper(r,c+1,m,vis,p+'R',ans);
        }
        if(isValid(r+1,c,m,vis))
        {
            helper(r+1,c,m,vis,p+'D',ans);
        }
        if(isValid(r,c-1,m,vis))
        {
            helper(r,c-1,m,vis,p+'L',ans);
        }
        vis[r][c] = false;

    }
    
    public static boolean isValid(int r,int c,int[][] m,boolean[][] vis)
    {
        if(r<0 || c<0 || r>=m.length || c>=m.length || m[r][c]==0 || vis[r][c])
            return false;
        
        return true;
    }
}