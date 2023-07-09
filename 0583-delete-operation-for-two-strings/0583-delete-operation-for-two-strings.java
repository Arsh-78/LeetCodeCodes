class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
        int[] cur = new int[m+1];
        
            Arrays.fill(prev,0);
            Arrays.fill(cur,0);
        
        //return lcSM(n,m,S1,S2,dp);
        int ans=0;
                
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                        
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    cur[j] = 1+prev[j-1];
                    ans = Math.max(ans,cur[j]);
                    
                }
                else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            
            prev = Arrays.copyOf(cur,m+1);
        }

        return (m+n - 2*ans);
    }
}