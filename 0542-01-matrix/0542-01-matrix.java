class Solution {
    public int[][] updateMatrix(int[][] mat) {

        Queue<Pair<int[],Integer>> q= new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        int[][] ans = new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=true;
                    ans[i][j]=0;
                    q.offer(new Pair(new int[]{i,j},0));
                }
                else
                {
                    ans[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int it =0;
        while(!q.isEmpty())
        {
            
            int d =q.peek().getValue();
            int r = q.peek().getKey()[0];
            int c = q.peek().getKey()[1];
            vis[r][c]=true;
            ans[r][c]=Math.min(d,ans[r][c]);
            q.remove();

            if(isValid(r-1,c,mat))
            {
                if(!vis[r-1][c])
                    q.offer(new Pair(new int[]{r-1,c},d+1));
            }
            if(isValid(r+1,c,mat))
            {
                if(!vis[r+1][c])
                q.offer(new Pair(new int[]{r+1,c},d+1));
            }
            if(isValid(r,c-1,mat))
            {
                if(!vis[r][c-1])
                q.offer(new Pair(new int[]{r,c-1},d+1));
            }
            if(isValid(r,c+1,mat))
            {
                if(!vis[r][c+1])
                q.offer(new Pair(new int[]{r,c+1},d+1));
            }
            
        }
        return ans;
    }

    public boolean isValid(int r,int c,int[][] mat)
    {
        if(r<0 || c<0 || r>=mat.length || c>=mat[0].length)
            return false;

        return true;
    }
}