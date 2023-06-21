class Solution {
    public void solve(char[][] board) {

        boolean[][] vis = new boolean[board.length][board[0].length];

        //top and bottom 
        for(int i=0;i<board[0].length;i++) 
        {
            if(!vis[0][i] && board[0][i]=='O')
                dfs(0,i,board,vis);

            if(!vis[board.length-1][i] && board[board.length-1][i]=='O')
                dfs(board.length-1,i,board,vis);
            
        }

        //left and right
        for(int i=0;i<board.length;i++) 
        {
            if(!vis[i][0]&& board[i][0]=='O')
                dfs(i,0,board,vis);

            if(!vis[i][board[0].length-1] && board[i][board[0].length-1]=='O')
                dfs(i,board[0].length-1,board,vis);
            
        }

        for(int i=0;i<board.length;i++) 
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(!vis[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }


        
    }

    public void dfs(int r, int c , char[][] board,boolean[][] vis)
    {
       
        if(r<0 || c<0 || r>board.length-1 || c>board[0].length-1 ||board[r][c]!='O')
        {
            return ;
        }
         
        else
        {
            vis[r][c]=true;
            if(isValid(r-1,c,board))
                if(!vis[r-1][c] && board[r-1][c]=='O')  
                    dfs(r-1,c,board,vis);

            if(isValid(r+1,c,board))
                if(!vis[r+1][c] && board[r+1][c]=='O')  
                    dfs(r+1,c,board,vis);

            if(isValid(r,c-1,board))
                if(!vis[r][c-1] && board[r][c-1]=='O')  
                    dfs(r,c-1,board,vis);

            if(isValid(r,c+1,board))
                if(!vis[r][c+1] && board[r][c+1]=='O')  
                    dfs(r,c+1,board,vis);
        

        }
    }

    boolean isValid(int r,int c,char[][] board)
    {
        if(r<0 || c<0 || r>=board.length-1 || c>board[0].length-1)
        {
            return false;
        }

        return true;
    }

}