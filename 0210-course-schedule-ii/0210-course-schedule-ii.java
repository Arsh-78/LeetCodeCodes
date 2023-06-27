class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
             int[] indeg = new int[numCourses];
     ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
     for(int i=0; i<numCourses;i++)
     {
         adj.add(new ArrayList<>());
     }

     for(int i=0; i<prerequisites.length;i++)
     {
         adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
     }   
     System.out.println(adj);
     for(int i=0;i<numCourses;i++)
     {
         for(int j : adj.get(i))
         {
             indeg[j]++;
         }
     }
     System.out.println(Arrays.toString(indeg));
     Queue<Integer> q = new LinkedList<>();
     for(int i=0;i<numCourses;i++)
     {
         if(indeg[i]==0)
            q.add(i);
     }
     ArrayList<Integer> tops = new ArrayList<>();

     while(!q.isEmpty())
     {
         int n = q.peek();
         q.remove();
         tops.add(n);
         
             for(int node : adj.get(n))
             {
                 indeg[node]--;
                 if(indeg[node]==0)
                    q.add(node);
             }
             
                 
     }
     System.out.println(tops);
     int[] ans = new int[numCourses];
     if(tops.size()==numCourses)
     {
         for(int i=0;i<tops.size();i++)
         {
             ans[i]=tops.get(i);
         }
         return ans;
     }
     else
     {
         return new int[]{};
     }
     
    }
}