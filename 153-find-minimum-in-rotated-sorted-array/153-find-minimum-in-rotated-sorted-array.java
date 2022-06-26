class Solution {
    public int findMin(int[] nums) {
        
        if(nums[0]<nums[nums.length-1])
        {
            return nums[0];
        }
       int pivot =pivotNum(nums);
        System.out.println(pivot);
        if(pivot==0 && nums.length!=1)
        {
            return nums[1];
        }
        
        return nums[pivot];
        
        
    }
    
    int pivotNum(int[] nums)
    {
        int start =0;
        int end = nums.length-1;
        int mid;
        while(start <= end)
        {
            mid=start + (end-start)/2;
            if(mid == nums.length-1 || mid==0)
            {
                return mid;
            }
            if(nums[mid]<nums[mid-1])
            {
                return mid;
            }
            if(nums[mid]<nums[mid+1] && nums[mid]<nums[nums.length-1])
            {
                end=mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return -1;
    }
}