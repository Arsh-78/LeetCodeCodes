class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int s = 1;
        int e=0;
        for(int i=0;i<weights.length;i++)
        {
            e+=weights[i];
        }
        int mid=0;
        int ans =0;
        while(s<=e)
        {
            mid = s+ (e-s)/2;
            if(helper(weights,mid) <= days)
            {
                ans = mid;
                e = mid-1;
            }
            else
            {
                s=mid+1;
            }
        
        }
       
        return ans;
        
        
    }
    
    public int helper(int[] weights,int cap)
    {
        int counter=0;
        int i=0;
        int pkgwt=0;
        int e = weights.length;
        while(i<weights.length)
        {
            pkgwt = pkgwt +weights[i];
            if(weights[i] > cap)
            {
                return Integer.MAX_VALUE;
            }
            if(pkgwt < cap )
            {
                if(i==e-1)
                {
                    counter++;
                    break;
                }
                i++;
                
            }
            else
            {
                
                if(pkgwt==cap)
                {
                    i++;
                }
               
                pkgwt=0;
               counter++;
            }
            
           
        }
        System.out.println("Capacity : " + cap+" Days: "+ counter);
        return counter;
    }
}