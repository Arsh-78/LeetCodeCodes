class Solution {
    public long minimumTime(int[] time, int totalTrips) {
         long low=Long.MAX_VALUE;
        long high=0;
        long min=Long.MAX_VALUE;
        for(int it:time){
            low=Math.min(low,it);
            min=Math.min(min,it);
        }
        high=totalTrips*min;
        while(low<high)
        {
            long mid = low +(high-low)/2;
            System.out.println(mid + " : "+canTbm(mid,time,totalTrips));
            if(canTbm(mid,time,totalTrips))
            {
                high = mid;
                
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
    
    public boolean canTbm(long t , int[] time,int totaltrips)
    {
        
        long tTrips=0;
        for(int i=0;i<time.length;i++)
        {
            tTrips += t/time[i];
        }
        
        return tTrips>=totaltrips ;
        
    }
}