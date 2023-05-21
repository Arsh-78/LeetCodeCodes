class Solution {
    public int tribonacci(int n) {
        int prev=0;
        if(n==0)
        {
            return 0;
        }
        int pr1=1;
        int pr2=1;
        int cur=0;
        for(int i=3;i<=n;i++)
        {
            cur = prev+pr1+pr2;
            prev=pr1;
            pr1=pr2;
            pr2=cur;
        }
        return pr2;
    }
}