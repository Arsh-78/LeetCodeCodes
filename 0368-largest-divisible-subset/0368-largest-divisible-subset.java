class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.sort(nums);
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(i,i);
        }
        int maxs=0;
        int li=0;
        
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i] % nums[j]==0 && 1 + dp[j] >dp[i])
                {
                    dp[i]=1+dp[j];
                    mp.put(i,j);
                }
            }
            if(dp[i]>maxs)
            {
                maxs=dp[i];
                li=i;
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(nums[li]);//as it wont add last element if you do it inside while loop before maxi get lne 
        while(mp.get(li) != li)
        {
            
            li=mp.get(li);
            ans.add(nums[li]);
        }
        
        Collections.reverse(ans);
        return ans;
    }
}