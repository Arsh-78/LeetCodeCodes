class Solution {
    public boolean search(int[] nums, int target) {
     int ans=0;
     int s=0;
     int e=nums.length-1;
     int mid=0;
     while(s<=e)
     {
         mid = s+(e-s)/2;

         if(nums[mid]==target)
         {
            return true;
         }
         if(nums[s]==nums[mid] && nums[e]==nums[mid])
         {
             s++;
             e--;
         }
         else if(nums[s]<= nums[mid])
         {
             if(target >= nums[s] && target<=nums[mid])
             {
                 e=mid-1;
             }
             else
             {
                 s=mid+1;
             }

         }
         else
         {
             if(target<=nums[e] && target >= nums[mid])
             {
                 s = mid+1;
             }
             else
                e=mid-1;


         }
     }  
     return false; 
    }
}