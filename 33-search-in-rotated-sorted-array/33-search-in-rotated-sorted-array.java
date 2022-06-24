class Solution {
    public int search(int[] nums, int target) {
        int start=0 ,end=nums.length-1,mid=0;
        int pivot = 0;
        
        int last_element = nums[end];
        int ans;
     
       if(nums[start]<nums[end] || nums.length==1)
        {
            return bS(nums,start,end,target);
        }
        
        while(start<=end)
        {
            mid=start +(end-start)/2;
            if(mid==0)
            {
                start++;
            }
            else if(nums[mid-1]>nums[mid])
            {
                pivot=mid-1;
                break;
            }
            else if(nums[end]<nums[mid])
            {
                start = mid+1;
            }
            else
            {
                end=mid-1;
            }
          
        }
     
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
      /*public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(mid == 0){
                start++;
            } else if(nums[mid - 1] > nums[mid]){
                return mid;
            } else if(nums[end] < nums[mid]){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return 0;
    }*/
    
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