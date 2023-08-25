class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> mp  = new HashMap<>();
        int start=0;
        int end=0;
        int max =0;
        int cur=0;
        while(start<=end && end < fruits.length)
        {
            if(mp.size()>2)
            {
              mp.put(fruits[start],mp.get(fruits[start])-1);
                if(mp.get(fruits[start])==0)
                { 
                    mp.remove(fruits[start]);
                    
                }
                   start++;
                  cur--;          
                    
            }
            else if(mp.size()==2 && !mp.containsKey(fruits[end]))
                   {
                       max = Math.max(cur,max);
                       mp.put(fruits[end],0);
                       
                       
                   }
            else
            {
                mp.put(fruits[end],mp.getOrDefault(fruits[end],0)+1);
                cur++;
                end++;
            }
        }
        return Math.max(cur,max);

    }
}