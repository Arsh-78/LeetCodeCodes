class Solution {
    public int search(int[] nums, int target) {
        int start=0 ,end=nums.length-1,mid=0,pivot=0;
        int last_element = nums[end];
        int ans;
     
        if(nums[start]<nums[end] || nums.length==1)
        {
            return bS(nums,start,end,target);
        }
        while(start<end)
        {
            if(nums[0]>nums[1])
            {
                pivot = 0;
                break;
            }
            mid=start +(end-start)/2;
            if((nums[mid]>nums[mid+1] && nums[mid] >nums[mid-1]))
            {   
                pivot = mid;
                break;
            }
            else if((nums[mid]<nums[mid+1] && nums[mid]<nums[mid-1]))
            {
                pivot = mid-1;
                break;
            }
            else if((nums[mid] <nums[mid+1] && nums[mid] >nums[mid-1]) 
                   && nums[mid]>last_element)
            {
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }
        }
        System.out.println(pivot);
        if(target <=last_element)
        {
            ans =bS(nums,pivot+1,nums.length-1,target);
        }
        else
        {
            ans = bS(nums,0,pivot,target);
        }
        return ans;
        
    }
    
    int bS(int[] nums,int start,int end,int target)
    {
        while(start<=end)
        {
            int mid  = start+(end-start)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
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