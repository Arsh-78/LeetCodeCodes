class Solution {
     class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n)
        {
            
        for(int i=0;i<n;i++)
            {
                parent.add(i);
                rank.add(0);
                size.add(1);
            }
        }

        int findPar(int x)
        {
            
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
     }
   
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String,Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(accounts.size());
        
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                if(!map.containsKey(accounts.get(i).get(j)))
                {
                    map.put(accounts.get(i).get(j),i);
                }
                else
                {
                    ds.unionBySize(i,map.get(accounts.get(i).get(j)));
                }
            }
        }
        //System.out.print(ds.parent);
        List<List<String>> a = new ArrayList<>();
        for(int i=0;i<ds.parent.size();i++)
        {
            a.add(new ArrayList<>());
            a.get(a.size()-1).add(accounts.get(i).get(0));
        }
        for(Map.Entry<String,Integer> e : map.entrySet())
        {
            a.get(ds.findPar(e.getValue())).add(e.getKey());
        }
        List<List<String>> ans = new ArrayList<>();
        {
            for(int i=0;i<a.size();i++)
            {
                if(a.get(i).size()!=1)
                {
                    Collections.sort(a.get(i).subList(1,a.get(i).size()));
                    ans.add(a.get(i));
                }
            }
        }
        //System.out.println(ans);

        return ans;
    }
    


}