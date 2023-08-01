/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    class Pair implements Comparable<Pair>{
        TreeNode node;
        int[] cell=new int[2];
        
        Pair(TreeNode node,int[] co){
            this.node = node;
            this.cell[0]=co[0];
            this.cell[1]=co[1];
        }
        
        @Override 
        public int compareTo(Pair p2)
        {
            if(this.cell[1]==p2.cell[1])
            {
                if(this.cell[0] !=p2.cell[0])
                    return this.cell[0] - p2.cell[0];
                else
                    return this.node.val-p2.node.val;
                    
            }
            else
                return this.cell[1]-p2.cell[1];
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
     
        
        int[] col = new int[2];
        mwidth(root,0,col);
        int lw=col[0];
        int rw = col[1];
        //System.out.println(lw+" "+rw);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<=Math.abs(lw)+rw;i++)
        {
            ans.add(new ArrayList<Integer>());
        }
        
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        
        inord(root,pq,0,0);
        while(!pq.isEmpty())
        {
            Pair cur = pq.poll();
            ans.get(cur.cell[1]+Math.abs(lw)).add(cur.node.val);
        }
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i).size()==0)
            {
                ans.remove(i);
            }
        }
        return ans;
        
    }
    
    public void mwidth(TreeNode root,int c,int[] col)
    {
        if(root==null)
            return ;
        
        if(c>col[1])
            col[1]=c;
        if(c<col[0])
            col[0]=c;
         mwidth(root.left,c-1,col);
         mwidth(root.right,c+1,col);
        
        
    }
    public void inord(TreeNode root,PriorityQueue<Pair> pq,int r ,int c)
    {
        if(root==null)
            return ;
        pq.offer(new Pair(root,new int[]{r,c}));
        inord(root.left,pq,r+1,c-1);
        
        //System.out.println(root.val + " "+c);
        inord(root.right,pq,r+1,c+1);
        
    }
}