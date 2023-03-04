class Solution {
    public long coloredCells(int n) {
        int i=1;
        long res=1;
        for(i=1;i<n;i++)
        {
            res = res + 4*(i);
        }
        return res;
    }
}