class Solution {
    public boolean canPartition(int[] nums) {

        int total =0;
        for(int i=0;i<nums.length;i++)
        {
            total+=nums[i];
        }
        if(total%2 !=0)
        {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][total*2];
        for(int i=0;i<nums.length;i++)
        {
            dp[i][total/2]=true;
        }
        for(int i=1;i<nums.length;i++)
        {
            for(int target = total/2;target>=0;target--)
            {
                
                boolean take = dp[i-1][target+nums[i]];
                boolean ntake = dp[i-1][target];
                dp[i][target] = take | ntake;
            }
        }
        return dp[nums.length-1][0];
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
        boolean take = canTw(i-1,curT+nums[i],nums,total,dp);
        boolean ntake = canTw(i-1,curT,nums,total,dp);

        dp[i][curT] = take | ntake== true ? 1 : 0;

        return take | ntake;
        
    }
}



//Memoization solution

// class Solution {
//     public boolean canPartition(int[] nums) {

//         int total =0;
//         for(int i=0;i<nums.length;i++)
//         {
//             total+=nums[i];
//         }
//         int[][] dp = new int[nums.length][total+1];
//         for(int i=0;i<nums.length;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
//         return canTw(nums.length-1,0,nums,total,dp);
//     }

//     public boolean canTw(int i,int curT,int[] nums ,int total,int[][] dp)
//     {
//         if(curT*2 == total)
//         {
//             return true;
//         }
//         if(i<0)
//         {
//             return false;
//         }
//         if(dp[i][curT]!=-1)
//         {
//             return dp[i][curT]==1;
//         }
// //System.out.println("index: "+i+" current subset sum: "+curT);
//         boolean take = canTw(i-1,curT+nums[i],nums,total,dp);
//         boolean ntake = canTw(i-1,curT,nums,total,dp);

//         dp[i][curT] = take | ntake== true ? 1 : 0;

//         return take | ntake;
        
//     }
// }