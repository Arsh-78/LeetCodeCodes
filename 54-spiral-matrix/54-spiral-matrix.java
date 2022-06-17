class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i,j;
        ArrayList<Integer> ans = new ArrayList();
        int s =0 ,er = matrix.length,ec=matrix[0].length;
        while(s < er && s < ec)
        {
            i=s ;
            j= s;
            while(j < ec)
            {
                ans.add(matrix[i][j]);
                j++;
            }
            j--;
            i++;
            
            while(i < er)
            {
                ans.add(matrix[i][j]);
                i++;
            }
            i--;
            j--;
            if( i<s || j < s)   //corner case if 1*n matrices or n*1
            {
                break ;
            }
            while(j>s && i != s)  //will add repetitive elments in case of n*1
            {
                ans.add(matrix[i][j]);
                j--;
            }
            
            while (i>s)
            {
                ans.add(matrix[i][j]);
                i--;
            }
            s++;
            er--;
            ec--;
        }
        return ans;
    }
}