class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0]=1;
        arr[n+1]=1;
        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<n+2;i++)
            Arrays.fill(dp[i],-1);
        
        for(int i=1;i<=n;i++)
        {
            arr[i]=nums[i-1];
        }
        return bbM(1,n,arr,dp);
    }
    
    public int bbM(int i,int j,int[] nums,int[][] dp)
    {
        if(i>j)
            return 0;
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int max = Integer.MIN_VALUE;
        for(int k = i ;k<=j;k++)
        {
            int cost = nums[i-1] *nums[k]*nums[j+1] + bbM(i,k-1,nums,dp) + bbM(k+1,j,nums,dp);
            
            max= Math.max(max,cost);

        }
        return dp[i][j]=max;
    }
}