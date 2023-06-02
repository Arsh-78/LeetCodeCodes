class Solution {
    public boolean exist(char[][] board, String word) {

     boolean[][] vis = new boolean[board.length][board[0].length]; 

     for(int i = 0 ; i<board.length;i++)
     {
         for(int j=0;j<board[0].length;j++)
         {
             if(board[i][j]==word.charAt(0))
             {
                 if(helper(board,vis,word,0,i,j))
                    return true;
             }
         }
     }  
     return false;
    }

    public boolean helper(char[][] board,boolean[][] vis,String word,int i, int r,int c)
    {
        if(i>word.length()-1)
        {
            return true;
        }
        if(r>=board.length || c>=board[0].length||r<0||c<0)
        {
            return false;
        }
        if(vis[r][c]==true)
        {
            return false;
        }
        if(board[r][c]!=word.charAt(i))
        {
            return false;
        }
        else
        {
            vis[r][c]=true;
            boolean down=false,up=false,l=false,rg=false;
            if(r<board.length)
            {
                down=helper(board,vis,word,i+1,r+1,c);
            }
            if(r>0)
            {
                up=helper(board,vis,word,i+1,r-1,c);
                
            }
             if(c<board[0].length)
            {
                rg=helper(board,vis,word,i+1,r,c+1);
            }
            if(c>0)
            {
                l=helper(board,vis,word,i+1,r,c-1);
                
            }

            boolean ans = up||down||l||rg;
            vis[r][c]=false;
            return ans;
        }

    }
}