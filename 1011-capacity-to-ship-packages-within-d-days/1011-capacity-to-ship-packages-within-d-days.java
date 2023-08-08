class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 1;
        int end = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<weights.length;i++)
        {
            end+=weights[i];
        }
        while(start<=end)
        {
            int mid = (start+end)/2;
            
            if(shipD(weights,mid) <=days)
            {
                ans=Math.min(ans,mid);
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
            
        }
        return ans;
    }
    
    public int shipD(int[] weights, int cap)
    {
        int cur=cap;
        int d=0;
        int i=0;
        while(i<weights.length)
        {
            if(weights[i]<= cur)
            {
                cur=cur-weights[i];
                i++;
            }
            else
            {
                if(weights[i]>cap)
                    return Integer.MAX_VALUE;
                else
                {
                    d++;
                    cur=cap;
                }
            }
        }
        //System.out.println(cap + " "+d);
        // if(cur!=0)
        //     return d+1;
        return d+1;
        }
    }
