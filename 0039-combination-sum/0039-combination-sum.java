class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> ans = new ArrayList<List<Integer>>();
     List<Integer> s = new ArrayList<>();
     helper(0,candidates,target,s,ans);
     return ans;
    }

    public void helper(int i ,int[] a,int target,List<Integer> cur,List<List<Integer>> ans)
    {
        if(i==a.length )
        {
            if(target==0)
                ans.add(new ArrayList<Integer>(cur));
            
            return;
        }
        if(target-a[i]>=0)
        {
            cur.add(a[i]);
            helper(i,a,target-a[i],cur,ans);
            cur.remove(cur.size()-1);
        }
        helper(i+1,a,target,cur,ans);
        
    }
}