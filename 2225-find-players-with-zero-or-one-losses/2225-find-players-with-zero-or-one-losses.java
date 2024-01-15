class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<matches.length;i++)
        {
            if(map.containsKey(matches[i][0])==false)
                map.put(matches[i][0],0);
            if(map.containsKey(matches[i][1])==false)
                map.put(matches[i][1],0);
            map.put(matches[i][1],map.get(matches[i][1])+1);
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        ans.add(new ArrayList<Integer>());
        ans.add(new ArrayList<Integer>());
        //System.out.println(Arrays.toString(tally));
       for(Map.Entry<Integer,Integer> e : map.entrySet())
       {
           if(e.getValue()==0)
           {
               ans.get(0).add(e.getKey());
           }
           else if(e.getValue()==1)
           {
               ans.get(1).add(e.getKey());
           }
       }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans ;
    }
}