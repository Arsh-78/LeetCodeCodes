class Solution {
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++)
        {
            if(s.contains(binaryf(i)))
            {
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
        
    }
    
    public String binaryf(int i)
    {
        if( i==1)
        {
            
            return Integer.toString(1);
        }
        else
        {
            String t="";
            while(i>1)
            {
                t=i%2+t;
                i=i/2;
            }
            t=i+t;
            return t;
            
        }
    }
}