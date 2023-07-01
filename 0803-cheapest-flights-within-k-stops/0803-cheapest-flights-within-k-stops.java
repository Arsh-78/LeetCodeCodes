class Solution {
    class Pair implements Comparable<Pair>{
        int s,c,stops;
        Pair(int a,int b,int c)
        {
            this.s=a;
            this.c=b;
            this.stops=c;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return this.stops-p2.stops;
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        int[] costs = new int[n];
        Arrays.fill(costs, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0 ;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new int[]{flights[i][1],flights[i][2]});
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0,0));
        costs[src]=0;
        while(!pq.isEmpty())
        {
            Pair f=pq.peek();
            int s=f.s;
            int fare = f.c;
            int ns=f.stops;
            pq.poll();
            System.out.println(s+" "+fare +" "+ns);
            for(int[] node : adj.get(s))
            {
                if(ns>k)
                {
                    break;
                }
                if(ns==k && node[0] != dst)
                {
                    continue;
                }
                if(costs[node[0]]>fare + node[1]  )
                {
                    costs[node[0]]=fare+node[1];
                    pq.add(new Pair(node[0],costs[node[0]],ns+1));
                }
            }
        }
        return costs[dst]==Integer.MAX_VALUE ? -1 : costs[dst];
    }
}