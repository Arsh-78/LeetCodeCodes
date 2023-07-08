class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        return findTM(nums.length-1,target,nums);
        
    }

    int findTM(int i,int target,int[] nums)
    {
        if(i==0)
        {
            if(target-nums[i]==0 || target + nums[0]==0)
            {
                if(nums[i]==0)
                    return 2;
                else
                    return 1;
            }
            return 0;
        }

        int sub = findTM(i-1,target-nums[i],nums);
        int add = findTM(i-1,target+nums[i],nums);
        
        return sub+add;
    }
}