class Solution {
    class Pair implements Comparable<Pair>{
        int r,c,d;
        Pair(int a,int b,int c)
        {
            this.r=a;
            this.c=b;
            this.d=c;
        }

        @Override
        public int compareTo( Pair p2)
        {
            return this.d-p2.d;
        }
    }
    public int minimumEffortPath(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq =new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        vis[0][0]=true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty())
        {
            Pair top = pq.peek();
            pq.poll();
            //System.out.println(top.r+" "+top.c+" "+top.d);
            vis[top.r][top.c]=true;
            for(int i=0;i<dirs.length;i++)
            {
                int r = top.r+dirs[i][0];
                int c= top.c+dirs[i][1];
                int d =top.d;
                if(isValid(r,c,grid))
                {
                    if(r==grid.length-1 && c==grid[0].length-1)
                    {
                        ans = Math.min(ans,Math.max(d,Math.abs(grid[r][c]-grid[top.r][top.c])));
                    }
                    if(vis[r][c])
                    {
                        continue;
                    }
                    else
                    {
                        pq.add(new Pair(r,c,Math.max(d,Math.abs(grid[r][c]-grid[top.r][top.c]))));
                    }
                }
            }
            
        }
        return ans==Integer.MAX_VALUE ? 0:ans;
    }

    boolean isValid(int r,int c,int[][] grid )
    {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length)
        {
            return false;
        }
        return true;
    }
}