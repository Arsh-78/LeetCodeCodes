class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int start =1;
        int end=0;
        int ans=Integer.MAX_VALUE;
        for(int i =0 ;i<nums.length;i++)
        {
            end=Math.max(nums[i],end);
        }
        while(start<=end)
        {
            int mid = (start+end)/2;
            int mis = res(nums,mid);
            if(mis<=threshold)
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
    
    public int res(int[] nums,int d)
    {
        int ans =0;
        for(int i=0;i<nums.length;i++)
        {
            ans+= Math.ceil(nums[i]/(float)d);
        }
        //System.out.println(ans);
        return ans;
    }
}