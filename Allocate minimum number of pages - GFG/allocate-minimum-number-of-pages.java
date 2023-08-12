//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int start=0;
        int end=0;
        if(M>N)
            return -1;
        for(int i=0;i<A.length;i++)
        {
            start = Math.max(start,A[i]);
            end+=A[i];
        }
        int ans=0;
        while(start<=end)
        {
            int mid = (start+end)/2;
            
            if(paged(A,mid) > M  )
            {
                start = mid+1; ///start ki pehli instance jispe condition meet hogi waha se tum second part mein jaane lagoge to start answer hoga
                
            }
            else
            {
                end=mid-1;
            
            }
        }
        return start;
    }
    
    public static int paged(int[] A ,int size)
    {
        int stdc=1;
        int curPage=0;
        
        for(int i=0;i<A.length;i++)
        {
            
            if(curPage + A[i] <=size)
            {
                curPage = A[i] +curPage;
            }
            else 
            {
                stdc++;
                curPage=A[i];
            }
            //System.out.println(stdc);
        }
        return stdc;
        
    }
};