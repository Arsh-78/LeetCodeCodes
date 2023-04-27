class Solution {
    public int bulbSwitch(int n) {
        if(n<2)
        {
            return n;
        }
        else if(n==2)
        {
            return 1;
        }
        else
        {
            
            return (int)Math.floor(Math.sqrt(n));
        }
    }
}