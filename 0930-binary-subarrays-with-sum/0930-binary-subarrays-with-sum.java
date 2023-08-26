class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
      
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        
        int pre=0;
        int c=0;
        for(int i=0;i<nums.length;i++)
        {
            pre=pre+nums[i];
            if(mp.containsKey(pre-goal))
            {
                c+=mp.get(pre-goal);
            }
            
            mp.put(pre,mp.getOrDefault(pre,0)+1);
        }
        return c;
        
    }
}