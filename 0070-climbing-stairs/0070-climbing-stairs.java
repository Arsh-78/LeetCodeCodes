class Solution {
    public int climbStairs(int n) {
        int prev=1;
        int prev2=2;
        if(n==1)
        {
            return prev;
        }
        int curs=0;
        for(int i=3;i<=n;i++)
        {
            curs = prev+prev2;
            prev=prev2;
            prev2=curs;
        }
        return prev2;

    }
}