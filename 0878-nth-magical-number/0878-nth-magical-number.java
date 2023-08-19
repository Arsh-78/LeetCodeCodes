class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int mod =1_000_000_007;
        long lcm =0;
        for(long i = Math.max(a,b);;i=i+Math.max(a,b))
        {
            if(i%Math.min(a,b)==0)
            {
                lcm = i;
                break;
            }
        }
        
        long low= Math.min(a,b);
        long high = (long)Math.min(a,b)*n;
        
        while(low<high)
        {
            long mid = low + (high-low)/2;
           
            if(mid/a + mid/b - mid/lcm < n)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        return (int)(low%mod);
    }
}