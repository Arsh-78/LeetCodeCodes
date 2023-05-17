class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        int cl=1;
        int maxl=1;
        if(nums.length==0)
        {
            return 0;
        }
        while(i<nums.length)
        {
            if(nums[i-1]+1==nums[i])
            {
                cl++;
                if(cl>maxl)
                {
                    maxl=cl;
                }
            }
            else if(nums[i-1]==nums[i])
            {
                i++;
                continue;
            }
            else
            {
                cl=1;
            }
            i++;
        }
        return maxl;

    }
}