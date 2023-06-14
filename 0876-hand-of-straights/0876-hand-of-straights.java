class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

     HashMap<Integer,Integer> mp = new HashMap<>();
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     for(int i=0;i<hand.length;i++)
     {
         mp.put(hand[i],mp.getOrDefault(hand[i],0)+1);
         pq.add(hand[i]);
     }   
     int curr = pq.peek();
     int c=groupSize;
     while(!pq.isEmpty())
     {
         if(mp.get(curr)==null || mp.get(curr)<=0)
         {
             return false;
         }
         pq.remove(curr);
         mp.put(curr,mp.get(curr)-1);
         c--;
         curr++;
         if(c==0)
         {
             c=groupSize;
             if(pq.isEmpty())
             {
                 break;
             }
             curr=pq.peek();
         }
         
     }
     if(c !=groupSize)
     {
         return false;
     }
     return true;
    }
}