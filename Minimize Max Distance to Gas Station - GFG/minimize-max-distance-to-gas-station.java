//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      int k = sc.nextInt();
      Solution obj = new Solution();
      double ans = obj.findSmallestMaxDist(a,k);
      System.out.printf("%.2f",ans);
      System.out.println();
    }
  }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
  public static double findSmallestMaxDist(int stations[],int K) {
    // code here
    
    double start =0;
    double end=0;
    for(int i=1;i<stations.length;i++)
    {
        end= Math.max(end,stations[i]-stations[i-1]);
    }
    
    double ans=1;
    while( end-start >= 0.00001)
    {
        
        double mid = (start+end)/2.00;
        
        if(stationC(stations,mid)>K)
        {
            ans=mid;
            start = mid;
            
        }
        else
        {
            //ans = mid;
            end = mid;
        }
    }
    //System.out.println(end);
    return end;

  }
  
  public static int stationC(int[] stations ,double dist)
  {
      int stc=0;
     
      
      int i=1;
      
      while(i<stations.length)
      {
          int curD=(int)((stations[i]-stations[i-1])/dist);
          
          stc += curD;
          
           i++;
      }
      
      return stc;
      
  }
}
     