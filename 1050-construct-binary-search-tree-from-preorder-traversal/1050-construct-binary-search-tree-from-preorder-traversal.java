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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode trav =root;
        int i=1;
        while(i<preorder.length)
        {
            insertNode(root,new TreeNode(preorder[i]));
            i++;
        }
        return root;
    }
    public void insertNode(TreeNode root,TreeNode node)
    {
        TreeNode trav = root;
        while(trav !=null)
        {
            if( trav.val >node.val)
            {
                if(trav.left == null)
                {
                    trav.left = node;
                    break;
                }
                trav=trav.left;
            }
            else if( trav.val < node.val)
            {
                if(trav.right == null)
                {
                    trav.right = node;
                    break;
                }
                trav=trav.right;
            }
        }
        
    }
}