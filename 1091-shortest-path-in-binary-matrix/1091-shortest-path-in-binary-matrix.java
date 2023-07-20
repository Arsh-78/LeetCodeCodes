class Solution {
    int ROW, COL;
    public int shortestPathBinaryMatrix(int[][] grid) {
           ROW = grid.length;
        COL = grid[0].length;
        
        if (grid[0][0] != 0 || grid[ROW - 1][COL - 1] != 0) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
        // destination unreachable
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        while(!q.isEmpty())
        {
            int r =q.peek()[0];
            int c = q.peek()[1];
            int d = grid[r][c];
            q.remove();
            
            if(r==ROW-1 && r==c)
            {
                return grid[r][c];
            }
            
            for(int[] dir : dirs)
            {
                int newr = r+dir[0];
                int newc= c+ dir[1];
                if(isBound(newr,newc) && grid[newr][newc]==0)
                {
                    grid[newr][newc]=1+d;
                    q.offer(new int[]{newr,newc});
                }
                    
            }
        }
        return -1;
    }
      boolean isBound(int row, int col) {
        return row>=0 && row<ROW && col>=0 && col<COL;
    }
}