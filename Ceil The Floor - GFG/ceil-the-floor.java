//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Pair ans = new Solve().getFloorAndCeil(arr, n, x);
            System.out.println(ans.floor + " " + ans.ceil);
        }
    }
}

class Pair {
    int floor, ceil;

    Pair() {
        this.floor = 0;
        this.ceil = 0;
    }

    Pair(int floor, int ceil) {
        this.floor = floor;
        this.ceil = ceil;
    }
}

// } Driver Code Ends


//User function Template for Java




class Solve {
    Pair getFloorAndCeil(int[] arr, int n, int x) {
        // code here
        
        Pair ans = new Pair(-1,Integer.MAX_VALUE);
        for(int i=0 ; i<n;i++)
        {
            if(arr[i] == x)
            {
                ans.ceil = arr[i];
                ans.floor = arr[i];
                break;
            }
            if(arr[i] > x && ans.ceil>arr[i])
            {
                ans.ceil = arr[i];
            }
            if(arr[i] < x && ans.floor<arr[i])
            {
                 ans.floor = arr[i];
            }
        }
        if(ans.ceil == Integer.MAX_VALUE)
        {
            ans.ceil=-1;
        }
        return ans;
    }
}

