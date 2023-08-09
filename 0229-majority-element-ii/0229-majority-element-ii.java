class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            
        }
        
        List<Integer> ans = new ArrayList<Integer>() ;
        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
            if(e.getValue() > nums.length/3 )
                ans.add(e.getKey());
        }
        
        return ans;
    }
}