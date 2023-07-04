class Solution {
    public int makeConnected(int n, int[][] connections) {

     if(connections.length <n-1)
     {
         return -1;
     }  

     int[] parent = new int[n];
     for(int i=0;i<n;i++)
     {
         parent[i]=i;
     }
     int ops=-1;
     for(int[] edge : connections)
     {
         union(edge[0],edge[1],parent);
     }
     for(int i=0;i<n;i++)
     {
         if(parent[i]==i)
            ops++;

     }

     return ops;

    }

    void union(int x,int z,int[] par)
    {
        if(par[x]==par[z])
            return;
        int px = findPar(x,par);
        int pz=findPar(z,par);

        par[px]=pz;
        
            }

    int findPar(int x,int[] par)
    {
        if(par[x]==x)
            return x;
        return par[x] = findPar(par[x],par);
    }
}