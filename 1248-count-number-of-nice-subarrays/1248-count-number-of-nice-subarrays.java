class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2 == 0)
            {
                nums[i]=0;
            }
            else
            {
                nums[i]=1;
            }
        }
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int start=0,end=0,count=0,cur=0;
        for(int i=0 ;i<nums.length;i++)
        {
            cur+=nums[i];
            if(mp.containsKey(cur-k))
            {
                count+=mp.get(cur-k);
            }
            
            mp.put(cur,mp.getOrDefault(cur,0)+1);
        }
        
        return count;
        
        
        
    }
}