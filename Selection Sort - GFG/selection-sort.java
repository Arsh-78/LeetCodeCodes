//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int l)
	{
        // code here such that selectionSort() sorts arr[]
        if(l==0)
        {
            return 0;
        }
        int maxIndex = 0;
        for(int i=0;i<=l;i++)
        {
            if(arr[i]>arr[maxIndex])
            {
                maxIndex=i;
            }
            
        }
        int temp = arr[l];
        arr[l]=arr[maxIndex];
        arr[maxIndex]=temp;
        return 0;
        
	}
	
	void selectionSort(int arr[], int n)
	{
	    //code here
	    
	   for(int i=0;i<arr.length;i++)
	   {
	       select(arr,n-i-1);
	   }
	}
}