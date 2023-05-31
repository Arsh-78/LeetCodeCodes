class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> fans = new ArrayList<List<Integer>>();
        fans.add(new ArrayList<Integer>());
        
        for(int i=0;i<nums.length;i++)
        {
            //
            int n=fans.size();
            for(int j=0 ;j<n;j++)
            {
             List<Integer> temp = new ArrayList<>(fans.get(j));
             temp.add(nums[i]);
             fans.add(temp);
            }

        }   
        System.out.println(fans);
        return fans;
    }
}