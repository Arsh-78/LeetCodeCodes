class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=3)
        {
            return n==1 ? true:false ;
        }
        else if(n%4==0)
        {
            return isPowerOfFour(n/4);
        }
        return false;
    }
}