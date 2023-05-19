//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        Queue<int[]> q= new LinkedList<>();
        int ic=image[sr][sc];
        image[sr][sc]=newColor;
        q.add(new int[]{sr,sc});
        while(!q.isEmpty())
        {
            int[] temp = q.poll();
            
            
            
            doRot(temp[0]+1,temp[1] ,image,q,ic,newColor);
            doRot(temp[0]-1,temp[1] ,image,q,ic,newColor);
            doRot(temp[0],temp[1] +1,image,q,ic,newColor);
            doRot(temp[0],temp[1] -1,image,q,ic,newColor);
            
                
            
        }
        
        return image;
        
        
    }
    
    public void doRot(int r,int c,int[][] grid,Queue<int[]> q,int ic ,int nc)
    {
     
     
     if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c]!=ic)
     {
         return;
     }
     if(grid[r][c]==nc)
     {
         return;
     }
     else
     {
         grid[r][c]=nc;
         q.add(new int[]{r,c});
         return;
     }
    }
    
    
    
}