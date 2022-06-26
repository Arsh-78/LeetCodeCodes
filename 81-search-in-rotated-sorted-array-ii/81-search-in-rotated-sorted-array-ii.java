class Solution {
    public boolean search(int[] nums, int target) {
       
        if(nums.length==1)
        {
            return nums[0]==target;
        }
        if(nums[0]<nums[nums.length-1])
        {
            return binarySearch(nums,0,nums.length-1,target);
        }
        int pivot = pivotNum(nums);
        System.out.println(pivot);
        if(target >=nums[pivot] && target<nums[0] )
        {
            return binarySearch(nums,pivot,nums.length-1,target); 
        }
        else
        {
             return binarySearch(nums,0,pivot-1,target);
        }
    }
    
    int pivotNum(int[] nums)
    {
       if(nums[0]>nums[1])
       {
           return 1;
       }
        else
        {
            for(int i =0 ;i<nums.length-1;i++)
            {
                if(nums[i]>nums[i+1])
                {
                    return i+1;
                }
            }
            return nums.length-1;
        }
        
    }
    
    boolean binarySearch(int[] nums ,int start,int end, int target)
        
    {
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]==target)
            {
                return true;
            }
            else if (nums[mid]>target)
            {
                end=mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return false;
    }
}