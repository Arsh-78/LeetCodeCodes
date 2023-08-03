//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);
                
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];
                
                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        
        int i=0;
        int cur=0;
        int max=0;
        ArrayList<ArrayList<Integer> > s = new ArrayList<ArrayList<Integer>>();
        
        while(cur<A.length && i<=cur)
        {
            if(i==cur)
            {
                cur++;
            }
            else if(A[max]-A[i] < A[cur]-A[i])
            {
                max=cur;
                
                if(cur==A.length-1 && A[max]-A[i]>0)
                {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(max);
                s.add(temp);
                }
                
                cur++;
                
                
            }
            
            else
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(max);
                s.add(temp);
                i=cur;
                max=cur;
                
            }
        }
        //System.out.println(s);
        int l=0;
        while(l<s.size())
        {
            
            if(s.get(l).get(0)==s.get(l).get(1))
                {s.remove(l);}
            else
                l++;
        }
        
       // System.out.println(s);
        return s;
    }
}
