class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans =new  ArrayList<List<Integer>>();
        
        long lt = (long)target;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
        {
            
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            
            for(int j=i+1;j<nums.length-1;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1])
                continue;
                
                
                
                int l=j+1;
                int k=nums.length-1;
                while(l<k)
                {
                    long sum=0;
                    sum+=nums[i];
                    sum+=nums[j];
                    sum+=nums[l];
                    sum+=nums[k];
                    if(sum<lt)
                    {
                        l++;
                    
                    }
                    else if(sum>lt)
                        k--;
                    else
                    {
                        ans.add(Arrays.asList(nums[i],nums[j],nums[l],nums[k]));
                        l++;
                        while(l<k && nums[l]==nums[l-1])l++;
                    
                    }
                    
                }                    
            }     
            
        }
        return ans;
        
    }
}
