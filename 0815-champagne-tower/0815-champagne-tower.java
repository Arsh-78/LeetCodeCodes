class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
     
        double[][] liq = new double[101][101];
        liq[0][0] = (double)poured;
        for(int i=0;i<=query_row;i++)
        {
            for(int j=0;j<=i;j++)
            {
                double c = (liq[i][j] -1)/2.0;
                if(c>0)
                {
                    liq[i+1][j] += c;
                    liq[i+1][j+1] +=c;
                }
            }
        }

        return Math.min(1,liq[query_row][query_glass]);
      
    }
}