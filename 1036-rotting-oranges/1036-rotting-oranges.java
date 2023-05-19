class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int[][] isRot = new int[grid.length][grid[0].length];
        Queue<int[]> rotot= new LinkedList<>();
        int time = 0;
        int r=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                {
                    rotot.add(new int[]{i,j});
                    
                    
                }
                else if(grid[i][j]==1)
                {
                    r++;
                }
            }
        }
        if(r==0)
        {
            return time;
        }
        int n= rotot.size();
        
        while(!rotot.isEmpty())
        {
            int[] temp = rotot.poll();
            n=n-1;
            
            
            if(doRot(temp[0]+1,temp[1] , grid,isRot,rotot))
            {
                r--;
            }
            if(doRot(temp[0]-1,temp[1] , grid,isRot,rotot))
            {
                r--;
            }
            if(doRot(temp[0],temp[1] +1, grid,isRot,rotot))
            {
                r--;
            }
            if(doRot(temp[0],temp[1] -1, grid,isRot,rotot))
            {
                r--;
            }
            
            
            if(n==0)
            {
                time++;
                n=rotot.size();
            }
            
        
        }
        
        return r==0 ? time-1 :-1;
    }
    
    public boolean doRot(int r,int c,int[][] grid,int[][] isRot,Queue<int[]> rotot)
    {
     
     
     if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c]==0)
     {
         return false;
     }
     if(grid[r][c]==2)
     {
         return false;
     }
     else
     {
         grid[r][c]=2;
         rotot.add(new int[]{r,c});
         return true;
     }
    }
}