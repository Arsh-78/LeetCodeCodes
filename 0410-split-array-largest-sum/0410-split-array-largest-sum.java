class Solution {
    public int splitArray(int[] nums, int k) {
        
        int start =0;
        int end=0;
        
        for(int i=0;i<nums.length;i++)
        {
            start= Math.max(start,nums[i]);
            end += nums[i];
        }
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(isSump(nums,mid)>k)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        return start;
    }
    
    public int isSump(int[] nums,int mSum)
    {
        int curSum=0;
        int sub=1;
        
        for(int i=0;i<nums.length;i++)
        {
            if(curSum+nums[i] <= mSum)
            {
                curSum = nums[i] +curSum;
            }
            else
            {
                sub++;
                curSum=nums[i];
            }
        }
        
        return sub;
    }
}