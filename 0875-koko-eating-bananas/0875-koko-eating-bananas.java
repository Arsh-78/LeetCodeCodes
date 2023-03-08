class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = Integer.MAX_VALUE;
        int mid=0;
        while(low<high)
        {
            mid= low + (high-low)/2;
            System.out.println(mid + " " +canF(piles,mid,h) );
            if(canF(piles,mid,h))
            {
                high =mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
    
    public boolean canF(int[] piles , int sp,int h)
    {
        int t=0;
        int i = 0;
        while(i<piles.length)
        {
            t += piles[i]/sp;
            if(piles[i] % sp !=0 )
            {
                t += 1;
            }
            i++;
        }
        
        return t<=h;
    }
}