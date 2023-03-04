class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftb=0;
        int rightb=0;
        int start =0 ;
        boolean minF=false;
        boolean maxF=false;
        long counter=0;
        int l=nums.length;
       for(int i=0;i<nums.length;i++)
       {
           if(nums[i]>maxK || nums[i]<minK)
           {
               maxF=false;
               minF=false;
               start=i+1;
           }
           if(nums[i]==maxK)
           {
               maxF=true;
               rightb=i;
           }
           if(nums[i]==minK)
           {
               minF=true;
               leftb=i;
           }
           if(maxF && minF)
           {
               counter += Math.min(leftb,rightb)-start +1;
           }
       }
        return counter;
    }
}