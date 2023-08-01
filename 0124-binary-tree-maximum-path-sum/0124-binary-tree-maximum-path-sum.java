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
    int maxS =0;
    public int maxPathSum(TreeNode root) {
        
        maxS=root.val;
        helperSum(root);
        return maxS;
    }
    
    public int helperSum(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int lsum = helperSum(root.left);
        if(lsum<0)
            lsum=0;
        int rsum = helperSum(root.right);
        if(rsum<0)
            rsum=0;
        int t=0; 
        
        t =  root.val +lsum+rsum;
        //System.out.println(lsum +" "+rsum+" "+t);
     
        maxS= Math.max(maxS,t);
        
        
        return root.val +Math.max(lsum,rsum);
    }
}