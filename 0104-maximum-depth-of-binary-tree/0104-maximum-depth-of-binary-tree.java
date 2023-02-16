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
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int depth =0;
        depth = calcDepth(root,0);
        return depth+1;
        
    }
    public int calcDepth(TreeNode root,int depth)
    {
        int ldepth =0;
        int rdepth=0;
       if(root.left == null && root.right==null)
       {
           return depth;
       }
       if(root.left!=null)
       {
           ldepth = calcDepth(root.left,depth+1);
       }
         if(root.right!=null)
       {
           rdepth = calcDepth(root.right,depth+1);
       }
        
       return ldepth>=rdepth ? ldepth : rdepth;
    }
}