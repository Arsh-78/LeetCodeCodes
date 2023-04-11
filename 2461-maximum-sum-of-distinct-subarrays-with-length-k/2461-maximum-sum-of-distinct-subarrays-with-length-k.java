class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>() ;
        long maxSum = 0, sum = 0 ;
        int i = 0, n = nums.length ;
        
        while (i < k) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1) ;
            sum += nums[i++] ;
        }
        
        if (map.size() == k) maxSum = sum ;
        
        while (i < n) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1) ;
            int val = map.get(nums[i-k]) ;
            map.put(nums[i-k], val-1) ;
            if (val == 1) map.remove(nums[i-k]) ;
            sum -= nums[i-k] ;
            sum += nums[i++] ;
            if (map.size() == k)
                maxSum = Math.max(maxSum, sum) ;
        }
        
        return maxSum ;
    }
}