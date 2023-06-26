class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp= new int[n];

        for(int i=0;i<n;i++)
        {
            dp[i]=matrix[n-1][i];  //Initiate all values to lowemost array
        }
        for(int i=n-2;i>=0;i--) //reverse traversal becausr straight can cause overlapping errors try [[-1],[3,2],[-3,1,-1]] for understanding
        {
            int[] tp= new int[n];
            for(int j=n-1;j>=0;j--)
            {
                int d=matrix[i][j] + dp[j];
                int r = Integer.MAX_VALUE;
                if(j!=n-1)
                {
                    r=matrix[i][j] + dp[j+1];
                }
                int l =Integer.MAX_VALUE;
                if(j!=0)
                {
                    l=matrix[i][j] + dp[j-1];
                }
                tp[j] = Math.min(d,Math.min(l,r));
            }
            dp=tp;
        }

        int ans = Integer.MAX_VALUE;

        for(int i : dp)
        {
            if(i<ans)
            {
                ans=i;
            }
        }
        return ans;
    }
}

