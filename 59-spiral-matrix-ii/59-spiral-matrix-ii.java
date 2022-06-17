class Solution {
    public int[][] generateMatrix(int n) {
        int s=0,i,j,num=1,er=n,ec=n;
        int[][] res = new int[n][n];
        
        while(s<er && s<ec)
        {
            i=s;
            j=s;
            while(j<ec)
            {
                res[i][j]=num;
                num++;
                j++;
            }
            j--;
            i++;
            while(i<er)
            {
                res[i][j]=num;
                num++;
                i++;
            }
            i--;
            j--;
            if(i<s || j<s)
            {
                break;
            }
            while(j>s & i != s)
            {
                res[i][j]=num;
                num++;
                j--;
            }
            while(i>s)
            {
                res[i][j]=num;
                num++;
                i--;
            }
            s++;
            er--;
            ec--;
        }
        return res;
        
    }
}