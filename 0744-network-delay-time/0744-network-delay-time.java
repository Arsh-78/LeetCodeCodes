class Solution {

    class Pair
    {
        int node;
        int time;
        Pair(int a,int b)
        {
            this.node=a;
            this.time=b;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
              
        int[] rtimes = new int[n];
        Arrays.fill(rtimes, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0 ;i<times.length;i++)
        {
            adj.get(times[i][0]-1).add(new int[]{times[i][1],times[i][2]});
        }

        Queue<Pair> pq = new LinkedList<>();
        rtimes[k-1]=0;
        pq.add(new Pair(k-1,0));
        
        while(!pq.isEmpty())
        {
            Pair inode= pq.peek();
            pq.remove();
            int cTime = inode.time;
            int cNode = inode.node;

            for(int[] adjNode : adj.get(cNode))
            {
                if(rtimes[adjNode[0]-1]>cTime + adjNode[1])
                {
                   rtimes[adjNode[0]-1] =cTime + adjNode[1];
                    pq.add(new Pair(adjNode[0]-1,rtimes[adjNode[0]-1]));
                }
            }
        }
        int min =Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(rtimes[i]>min)
            {
                min=rtimes[i];
            }
        }
        return min==Integer.MAX_VALUE ? -1 : min;
        
    }
}