//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n+5];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n-1; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.missingNumber(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {
    
    public static int missingNumber(int A[], int N)
    {
         // Your code goes here
         
         //indexing properly
         
         int i=0;
         while(i<A.length)
         {
             int correctIndex=A[i]-1;
             if(A[i]==0)
             {
                 i++;
                 continue;
             }
             if(A[correctIndex] !=A[i])
             {
                 swap(A,i,correctIndex);
             }
             else
             {
                 i++;
             }
         }
         for(int j=0;j<A.length;j++)
         {
             if(A[j]!=j+1)
             {
                 return j+1;
             }
         }
         return -1;
    }
    
    public static void swap(int[] arr,int i,int correct)
    {
        int temp=arr[correct];
        arr[correct]=arr[i];
        arr[i]=temp;
    }
}