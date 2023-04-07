//{ Driver Code Starts
//Initial Template for Java
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
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        
        int start =0;
        int end=0;
        long winsum=0;
        long currSum=0;
        while(end-start+1 <=K)
        {
            currSum += Arr.get(end);
            end++;
        }
        winsum = currSum;
        while(end<N)
        {
            //System.out.println(currSum);
            currSum = currSum+Arr.get(end)-Arr.get(start);
            
            if(currSum>winsum)
            {
                winsum=currSum;
            }
            start++;
            end++;
        }
        return winsum;
        
    }
}