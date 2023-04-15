class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(n,1);
        while(true)
        {
            if(sqsum(n)==1)
            {
                return true;
            }
            else
            {
                if(map.containsKey(sqsum(n)))
                {
                    return false;
                }
                else
                {
                    map.put(sqsum(n),1);
                    n=sqsum(n);
                }
                
            }
            
        }
    }
    
    public int sqsum(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=Math.pow(n%10,2);
            n=n/10;
        }
        return sum;
    }
}