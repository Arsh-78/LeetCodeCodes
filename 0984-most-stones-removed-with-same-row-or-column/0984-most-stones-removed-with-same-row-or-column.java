class Solution {
    class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n)
        {
            
            for(int i=0;i<=n;i++)
            {
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        int findPar(int x)
        {
            System.out.println(x);
            if(x==parent.get(x))
                return x;
                
            parent.set(x,findPar(parent.get(x)));  
            return parent.get(x);
        }
        void unionBySize(int x,int z)
        {
            int ux=findPar(x);
            int uz=findPar(z);
            if(findPar(x)==findPar(z))
                return;
            if(size.get(ux)<size.get(uz))
            {
                parent.set(ux,uz);
                size.set(uz,size.get(uz)+size.get(ux));
            }
            
            else
            {
                parent.set(uz,ux);
                size.set(ux,size.get(uz)+size.get(ux));
            }
            

        }
        void unionByRank(int x,int z)
        {
            int ux=findPar(x);
            int uz=findPar(z);
            if(findPar(x)==findPar(z))
                return;
            if(rank.get(ux)<rank.get(uz))
            {
                parent.set(ux,uz);
            }
            else if(rank.get(ux)>rank.get(uz))
            {
                parent.set(uz,ux);
            }
            else
            {
                parent.set(uz,ux);
                int rankU = rank.get(ux);
                rank.set(ux,rankU+1);
            }
            
        }
        int getC()
        {
            int c=0;
            for(int i=0;i<parent.size();i++)
            {
                //System.out.println(parent.get(i)+" " +size.get(i));
                if(parent.get(i)==i && size.get(i) > 1) 
                {
                    c++;
                }
            }
            return c;
        }

    }
    public int removeStones(int[][] stones) {
        
        int maxR=0,maxC=0;
        int n = stones.length;
        
        for(int i=0;i<n;i++)
        {
            maxR=Math.max(maxR,stones[i][0]);
            maxC=Math.max(maxC,stones[i][1]);
        }
        int s = maxR+maxC+2;
        DisjointSet ds = new DisjointSet(s);
        
        for(int i=0;i<n;i++)
        {
            int nodeR=stones[i][0];
            int nodeC=maxR+1+stones[i][1];
            ds.unionBySize(nodeR,nodeC);
        }
        int comp = ds.getC();
        return n-comp;

    }
}