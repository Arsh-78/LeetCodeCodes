class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
           List<List<Integer>> fans = new ArrayList<List<Integer>>();
        fans.add(new ArrayList<Integer>());
        
        int start =0;
        int end=0;
        for(int i=0;i<nums.length;i++)
        {
            //
            start=0;
            if(i>0 && nums[i]==nums[i-1])
            {
                start=end+1;
            }
            int n=fans.size();
            end=fans.size()-1;
            for(int j=start ;j<n;j++)
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