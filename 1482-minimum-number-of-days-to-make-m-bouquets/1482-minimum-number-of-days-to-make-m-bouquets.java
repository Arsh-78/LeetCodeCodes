class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
     
        
        int sd=0;
        int ed=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            ed =Math.max(bloomDay[i],ed);
        }
        int min=Integer.MAX_VALUE;
        while(sd<=ed)
        {
            int mid = (sd+ed)/2;
            int miD=groupk(bloomDay,mid,k);
            if(miD>=m)
            {
                min = Math.min(min,mid);
                ed=mid-1;
            }
            else{
                sd=mid+1;
            }      
            
        }
        return min==Integer.MAX_VALUE ? -1 :min;
    }
    
    public int groupk(int[] bloomDay,int d,int k)
    {
        int ans=0;
        int i=0;
        int l=0;
        while(i<bloomDay.length)
        {
                      
            if(bloomDay[i]<=d)
            {
                l++;
                if(l==k)
                {
                    ans++;
                    l=0;
                }
            }
            else
            {
                l=0;
             }
            i++;
        }
        //System.out.println(d+" "+ans);
        return ans;
    }
}