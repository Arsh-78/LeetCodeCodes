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
    public int diameterOfBinaryTree(TreeNode root) {
        
        return helper(root,0);
    }
    
    
    public int helper(TreeNode root,int maxD)
    {
     
        if(root==null)
        {
            return maxD;
        }
        else
        {
            int l = height(root.left);
            int r = height(root.right);
            maxD = Math.max(maxD,l+r);
            l=helper(root.left,maxD);
            r=helper(root.right,maxD);
            return Math.max(maxD,Math.max(l,r));
            
            
        }
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
        int ld=height(root.left);
        int rd=height(root.right);
        
        return 1+Math.max(ld,rd);
    }
}