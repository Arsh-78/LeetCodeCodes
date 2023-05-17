class Solution {
    public int findPeakElement(int[] nums) {
     int s=0;
     int e =nums.length-1 ;
     int peak = nums[0];
     int mid = 0;
     int peakIndex=0;
     if(nums.length<=1)
     {
         return 0;
     }
     while(s<=e)
     {
         mid = s+ (e-s)/2;
         if(mid==nums.length-1)
         {
             return peakIndex;
         }
         if(nums[mid+1]>=nums[mid])
         {
             peak = nums[mid+1];
             peakIndex=mid+1;
             s=mid+1;
         }
         else
         {
             peakIndex=mid;
             peak=nums[mid];
             e=mid-1;
         }


     }
     return peakIndex;
    }
}