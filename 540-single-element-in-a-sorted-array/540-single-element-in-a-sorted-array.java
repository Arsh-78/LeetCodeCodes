class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start =0;
        int end = nums.length-1,mid;
        while(start<=end)
        {
           
            mid= start + (end-start)/2;
             if(mid==nums.length-1)
            {
                return nums[mid];
            }
            if(mid==0)
            {
                return nums[mid];
            }
            if(nums[mid]==nums[mid+1])
            {
                if(mid%2==0)
                {
                    start=mid+1;
                }
                else
                {
                    end = mid-1;
                }
            }
            else if(nums[mid]==nums[mid-1] )
            {
                if(mid%2==0)
                {
                end = mid-1;
                }
                else
                {
                    start = mid+1;
                }
                
            }
            else
            {
                return nums[mid];
            }
        }
        return -2;
    }
}