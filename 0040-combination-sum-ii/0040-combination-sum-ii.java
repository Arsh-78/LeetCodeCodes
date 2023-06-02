class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,0,ans,temp);
        
        return ans;
    }

//helper(candidates,target,i+1,curSum,fans,temp);
    public void helper(int[] candidates,int target,int i,int curSum, List<List<Integer>> fans,ArrayList<Integer> temp)
    {
        
        
        if(curSum==target)
        {
            if(!fans.contains(new ArrayList<Integer>(temp)))
            {
                fans.add(new ArrayList<Integer>(temp));
            }
            
            return ;
        }
        if(i>=candidates.length || curSum>target)
        {
            return;
        }
        else
        {   
            
            temp.add(candidates[i]);
            helper(candidates,target,i+1,curSum+candidates[i],fans,temp);
            temp.remove(temp.size()-1);

            int j=i+1;
            while(i+1<candidates.length && candidates[i]==candidates[i+1])
                i++;

            helper(candidates,target,i+1,curSum,fans,temp);    
    
            return;
        }
    }
}