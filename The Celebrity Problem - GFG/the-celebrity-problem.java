//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	int z=0;
    	boolean isC=true;
    	for(int i=0;i<n;i++)
    	{
    	    if(i!=0 && M[0][i]==1 && M[i][0]==0)
    	        st.push(i);
    	       
    	       if(i!=0 && M[i][0]==0)
    	            isC=false;
    	   if(M[0][i]==0)
    	    z++;
    	            
    	        
    	}
    	
    	if(isC && z==M.length)
    	    return 0;
    	    
    	int ans = -1;
    	while(!st.isEmpty())
    	{
    	    int cz=0;
    	    int ci = st.pop();
    	    for(int i=0;i<n;i++)
    	    {
    	        if(ci != i && M[ci][i]==0 && M[i][ci]==1)
    	            cz++;
    	    }
    	    if(cz==M.length-1)
    	        return ci;
    	}
    	return ans;
    }
}