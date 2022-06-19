class Solution {
    public boolean canJump(int[] nums) {
     int g= nums.length-1;
        for(int i=g-1;i>=0;i--)
        {
            if(nums[i]+i>=g)
            {
                g=i;
            }
        }
        return g==0;
    }
}