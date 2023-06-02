class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp = new ArrayList<>();
        helper(candidates,target,0,0,ans,temp);
        return ans;
    }

//helper(candidates,target,i+1,curSum,fans,temp);
    public void helper(int[] candidates,int target,int i,int curSum, List<List<Integer>> fans,ArrayList<Integer> temp)
    {
        
        if(i>=candidates.length)
        {
            return;
        }
        if(curSum>target)
        {
            
            return;
        }
        if(curSum==target)
        {
            
            fans.add(new ArrayList<Integer>(temp));
            return ;
        }
        else
        {
            temp.add(candidates[i]);
            helper(candidates,target,i,curSum+candidates[i],fans,temp);
            temp.remove(temp.size()-1);
            helper(candidates,target,i+1,curSum,fans,temp);
            return;
        }
    }
}