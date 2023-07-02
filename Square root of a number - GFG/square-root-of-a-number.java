//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			long a = sc.nextInt();
			Solution obj = new Solution();
			System.out.println(obj.floorSqrt(a));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution
{
     long floorSqrt(long x)
	 {
		// Your code here
		long s =1;
		long e =x;
		long mid=1;
		if(x<4)
		{
		    return 1;
		}
		while(s<=e)
		{
		    mid=s+(e-s)/2;
		    
		    if(mid==x/mid)
		    {
		        return mid;
		    }
		    else if(mid>x/mid)
		    {
		        e=mid-1;
		    }
		    else
		    {
		        s=mid+1;
		    }
		}
		return e;
	 }
}
