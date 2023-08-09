class Solution {
    public List<List<Integer>> generate(int numRows) {
        int start =0;
        int end = 0;
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i=1;i<=numRows;i++)
        {
            ans.add(new ArrayList<>());
        }
        
        ans.get(0).add(1);
        for(int i=1;i<numRows;i++)
        {
            ans.get(i).add(1);
            for(int j=1;j<i;j++)
            {
                ans.get(i).add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            ans.get(i).add(1);
        }
        
        return ans;
    }
}