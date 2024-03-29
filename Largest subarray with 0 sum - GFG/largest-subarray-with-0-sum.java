//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> mp = new HashMap<>();
        int cur=0;
        int maxL=0;
        mp.put(0,-1);
        for(int i=0 ;i<arr.length;i++)
        {
            cur+=arr[i];
            if(!mp.containsKey(cur))
                mp.put(cur,i);
            else
            {
                    
                maxL=Math.max(maxL,i-mp.get(cur));
            }
        }
        return maxL;
    }
}