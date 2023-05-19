class Solution {
    public int islandPerimeter(int[][] grid) {
        int p=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    int temp = 4;
                    if(!checkLand(i+1,j,grid))
                    {
                        temp--;
                    }
                    if(!checkLand(i-1,j,grid))
                    {
                        temp--;
                    }
                    if(!checkLand(i,j+1,grid))
                    {
                        temp--;
                    }
                    if(!checkLand(i,j-1,grid))
                    {
                        temp--;
                    }
                    p+=temp;
                }
            }
        }
        return p;
    }

    public boolean checkLand(int r,int c,int[][] grid)
    {
        if(r<0 || c<0 ||r>grid.length-1 || c>grid[0].length-1||grid[r][c]==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}