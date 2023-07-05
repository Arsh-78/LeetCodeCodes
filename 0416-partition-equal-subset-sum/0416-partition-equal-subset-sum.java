class Solution {
    public boolean canPartition(int[] nums) {

        int total =0;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
        int[][] dp = new int[nums.length][total+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return canTw(nums.length-1,0,nums,total,dp);
    }

    public boolean canTw(int i,int curT,int[] nums ,int total,int[][] dp)
    {
        if(curT*2 == total)
        {
            return true;
        }
        if(i<0)
        {
            return false;
        }
        if(dp[i][curT]!=-1)
        {
            return dp[i][curT]==1;
        }
//System.out.println("index: "+i+" current subset sum: "+curT);
        boolean take = canTw(i-1,curT+nums[i],nums,total,dp);
        boolean ntake = canTw(i-1,curT,nums,total,dp);

        dp[i][curT] = take | ntake== true ? 1 : 0;

        return take | ntake;
        
    }
}