class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[9];
        boolean[] vis = new boolean[9];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=i+1;
        }
        List<List<Integer>> fans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(nums,k,n,0,0,fans,temp);
        return fans;
    }

    void helper(int[] nums,int k,int n,int i,int curSum,List<List<Integer>> fans,List<Integer> temp)
    {
        if(temp.size()==k && curSum==n)
        {
            fans.add(new ArrayList<Integer>(temp));
            return;
        }
        if(temp.size()>k || curSum>n)
        {
            return;
        }
        if(i>=nums.length)
        {
            return;
        }
        else
        {
            temp.add(nums[i]);
            helper(nums,k,n,i+1,curSum+nums[i],fans,temp);
            temp.remove(temp.size()-1);
            helper(nums,k,n,i+1,curSum,fans,temp);
        }
    
    }
}