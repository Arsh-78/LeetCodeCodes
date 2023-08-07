class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[n+1][k+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return segM(n,k,dp);
    }
    
    public int segM(int f ,int e,int[][] dp)
    {
        if(e==1 || f==0 || f==1)
            return f;
        
        if(dp[f][e]!=-1)
            return dp[f][e];
        
//         for(int i=1;i<=f;i++)
//         {
//             int temp = 1 + Math.max(segM(i-1,e-1,dp),segM(f-i,e,dp));
            
//             min = Math.min(min,temp);
    
//         }
        int min = Integer.MAX_VALUE;
        
        int lf=0;
        int hf =f;
        
        while(lf<=hf)
        {
             int lbr=0;
            int nbr=0;
            int mid = (hf+lf)/2;
            
            if(dp[mid-1][e-1]!=-1)  //check kro ki anda toota to kya iske neeche ki floors k solved hai question
                lbr=dp[mid-1][e-1];
            else
            {
                lbr = segM(mid-1,e-1,dp);
                dp[mid-1][e-1]=lbr;
            }
            
            if(dp[f-mid][e] !=-1)  //likewise nhit toota to
                nbr=dp[f-mid][e];
            else
            {
                nbr = segM(f-mid,e,dp);
                dp[f-mid][e]=nbr;
            }
                           
            if(lbr>nbr)
                hf=mid-1;
            else
                lf=mid+1;
            
            int temp = 1+Math.max(lbr,nbr);
            min = Math.min(min,temp);
        }
        return dp[f][e]=min;
    }
}


 