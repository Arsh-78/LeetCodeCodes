class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[] minC = new int[n];
        Arrays.fill(minC,0);
        int[][] adj = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    adj[i][j] = (int)1e8;
                }
                else
                {
                    adj[i][j]=0;
                }
            }
        }
        for(int[] edge : edges)
        {
            adj[edge[0]][edge[1]]= edge[2];
            adj[edge[1]][edge[0]]= edge[2];
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    adj[i][j] = Math.min(adj[i][j],adj[i][k] + adj[k][j]);
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(adj[i][j]<=distanceThreshold && adj[i][j] !=0)
                {
                    minC[i]++;
                }
            }
        }
        int ans=n-1;
        for(int i=n-1;i>=0;i--)
        {
            System.out.print(i+" ");
        }
        for(int i=n-1;i>=0;i--)
        {
            if(minC[ans]>minC[i])
            {
                ans=i;
            }
        }
        return ans;

    }
}