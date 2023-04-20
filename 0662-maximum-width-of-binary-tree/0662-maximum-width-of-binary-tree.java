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

public class indexNode
{
    TreeNode node;
    int pos;
    
    indexNode(){}
    
    indexNode(TreeNode node,int pos){
        
        this.node=node;
        this.pos=pos;
    }
    
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        
        
        return bfs(root,0);
        
    }
    
    public int bfs(TreeNode root,int max)
    {
        Queue<indexNode> q = new LinkedList<indexNode>();
        List<ArrayList<Integer>> wList = new ArrayList<ArrayList<Integer>>();
        
        if(root==null)
        {
            return 0;
        }
        q.offer(new indexNode(root,0));
        
        while(!q.isEmpty())
        {   
            int num =q.size();
            int min =q.peek().pos;
            
            int left=0,right=0;
            for(int i=0;i<num;i++)
            {
                
                int cur_pos=q.peek().pos;
                TreeNode temp = q.poll().node;
                if(i==0)
                    left=cur_pos;
                if(i==num-1)
                    right=cur_pos;
                
                if(temp.left!=null)
                {
                    
                    q.offer(new indexNode(temp.left,2*cur_pos));
                }
                    
                if(temp.right!=null)
                {
                    q.offer(new indexNode(temp.right,2*cur_pos+1));
                    
                }
            }
            max=Math.max(max,right-left+1);
        }
        return max;
        
    }
}