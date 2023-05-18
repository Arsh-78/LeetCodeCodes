class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] isnz = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<edges.size();i++)
        {
            isnz[edges.get(i).get(1)]=true;
        }  
        for(int i=0 ; i<isnz.length;i++)
        {
            if(isnz[i]==false)
            {
                ans.add(i);
            }
        } 
        return ans;
    }
}