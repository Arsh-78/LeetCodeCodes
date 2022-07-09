class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=1)
        {
            return n==1 ? true:false ;
        }
        else if(n%2==0)
        {
            return isPowerOfTwo(n/2);
        }
        return false;
            
    }
}