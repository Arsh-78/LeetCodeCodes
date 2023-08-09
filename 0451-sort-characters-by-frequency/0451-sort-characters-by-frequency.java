class Solution {
    class Pair implements Comparable<Pair>{
        char c;
        int i;
        Pair(char c ,int n)
        {
            this.c = c;
            this.i=n;
        }
        
        @Override
        public int compareTo(Pair p2)
        {
            return p2.i - this.i;
        }
    }
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> mp =new HashMap<>();
        char[] car = s.toCharArray();
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        
        for(int i=0;i<car.length;i++)
        {
            mp.put(car[i],mp.getOrDefault(car[i],0)+1);
            //System.out.println(mp.get(car[i]));
        }
        
        for(Map.Entry<Character,Integer> e : mp.entrySet())
        {   
           pq.offer(new Pair(e.getKey(),e.getValue()));   
        }
        String ans = "";
        while(!pq.isEmpty())
        {
            Pair cur = pq.poll();
            int l=0;
            while(l<cur.i)
            {
                ans+= cur.c;
                l++;
            }
        }
        return ans;
        
    }
}