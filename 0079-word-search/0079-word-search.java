class Solution {
    public boolean exist(char[][] board, String word) {
     
        boolean[][] vis = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(helper(0,i,j,board,word,vis))
                    {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(int j,int r,int c,char[][] board, String word,boolean[][] vis)
    {
        if(j==word.length()-1)
        {
            return true;
        }
        vis[r][c]=true;
        
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        
        boolean a = false;
        for(int i=0;i<dirs.length;i++)
        {
            int nr = r+dirs[i][0];
            int nc = c + dirs[i][1];
            
            if(isValid(j+1,nr,nc,board,vis,word))
                a= a | helper(j+1,nr,nc,board,word,vis);
        }
        vis[r][c]=false;
        return a;
        
        
    }
    
    public boolean isValid(int i,int r,int c,char[][] board,boolean[][] vis,String word)
    {
        if(r>=board.length || c>=board[0].length ||r<0||c<0 || vis[r][c]==true || word.charAt(i) != board[r][c])
             return false;
        
        return true;
    }
}