class Solution {
    public int countPrimes(int n) {
        boolean[] ps = new boolean[n];
        
        for(int i=2;i*i<n;i++)
        {
            if(!ps[i])
            {
                for(int j=i*2;j<n;j=j+i)
                {
                    ps[j]=true;
                }
 
            }
        }
        
        int c=0;
        for(int i=2;i<n;i++)
        {
            if(!ps[i])
                c++;
        }
        
        return c;
    }
}