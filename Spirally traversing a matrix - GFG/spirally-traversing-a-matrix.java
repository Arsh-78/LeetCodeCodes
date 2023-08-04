//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<int[]> dir = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        dir.add(new int[]{0,1});
        dir.add(new int[]{1,0});
        dir.add(new int[]{0,-1});
        dir.add(new int[]{-1,0});
        int lr = 0;
        int lc = 0;
        int i=0;
        int j=0;
        int d=0;
        
        while(lr<=r && lc<=c){
            
            if(i>=r || i<lr || j>=c || j<lc)
            {
                
                if(i>=r || i<lr)
                {
                    if(i>=r)
                    {
                        c--;
                    }
                    else
                    {
                        lc++;
                    }
                    
            
                }
                else
                {
                    if(j>=c)
                    {
                    lr++;
                    }
                    else
                    {
                        r--;
                    }
                    
                }
                i=i-dir.get(d)[0];
                j=j-dir.get(d)[1];
                d=(d+1)%4;
                i=i+dir.get(d)[0];
                j=j+dir.get(d)[1];
                //System.out.println(lr+" "+r+" "+lc+" "+c+"\n");
            }
            else
            {
                //System.out.println(matrix[i][j]);
                ans.add(matrix[i][j]);
                i=i+dir.get(d)[0];
                j=j+dir.get(d)[1];
            }
            
            
        }
        return ans;
    }
}
