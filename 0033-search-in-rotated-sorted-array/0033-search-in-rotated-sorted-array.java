class Solution {
    public int search(int[] nums, int target) {
        
        int start=0;
        int end=nums.length-1;
        int mid =0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            
            if(nums[mid]==target)
                return mid;
         if(nums[start]<=nums[mid])
            {
                if(target < nums[mid]  && nums[start]<=target)
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }
            else
            {
                if(nums[mid] < target && target <=nums[end])
                {
                    start=mid+1;
                }
                else
                {
                    end=mid-1;
                }
                
            }
        }
        return -1;
    }
}
// }
// class Solution {
//     public int search(int[] nums, int target) {
//         int low = 0, high = nums.length - 1;

//         while (low <= high) {
//             int mid = (low + high) / 2;

//             if (nums[mid] == target) {
//                 return mid;
//             }

//             if (nums[low] <= nums[mid]) {
//                 if (nums[low] <= target && target < nums[mid]) {
//                     high = mid - 1;
//                 } else {
//                     low = mid + 1;
//                 }
//             } else {
//                 if (nums[mid] < target && target <= nums[high]) {
//                     low = mid + 1;
//                 } else {
//                     high = mid - 1;
//                 }
//             }
//         }

//         return -1;
//     }
// }