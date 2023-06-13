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
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    for(int i=arr.length/2 ; i>=0;i--)
    {
        heapify(i,N,arr);
    }
  }
  
  static void heapify(int i ,int size,int[] arr)
  {
      int left = 2*i+1;
      int right = 2*i+2;
      int maxIn = i;
      
      if(left < size && arr[left]>arr[maxIn])
      {
          maxIn=left;
      }
      if(right < size && arr[right]>arr[maxIn])
      {
          maxIn=right;
      }
      
      if(maxIn != i)
      {
          int temp = arr[i];
          arr[i]=arr[maxIn];
          arr[maxIn]=temp;
          
          heapify(maxIn,size,arr);
      }
      
  }
}
     