class Solution {
    public int singleNonDuplicate(int[] nums) {
     int s=0;
     int e = nums.length-1;
     if(e==0)
     {
         return nums[0];
     }
     
     while(s<=e)
     {
         if(s==e)
         {
             return nums[s];
         }
     
        if(nums[s]==nums[s+1])
        {
            s=s+2;
        }
        if(nums[e]==nums[e-1])
        {
            e=e-2;
        }
        else
        {
            return nums[e];
        }
     }   
     return -1;
    }
}