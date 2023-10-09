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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        TreeNode trav =root;
        TreeNode prev=null;
        if(root==null)
        {
            return prev;
        }
       if(root.val==key)
       {
           return delNode(root);
       }
        while(trav!=null)
        {
            if(trav.val == key)
            {
                if(prev.val>trav.val)
                {
                    prev.left=delNode(trav);
                }
                else
                {
                    prev.right=delNode(trav);
                }

                
                break;
            }
            else if(trav.val>key)
            {
                prev=trav;
                trav=trav.left;
                
            }
            else
            {
                prev=trav;
                trav=trav.right;
            }
        }
        return root;
    }
    TreeNode delNode(TreeNode trav)
    {
        //System.out.println(trav.val);
        
        if(trav.left==null)
            return trav.right;
        else if(trav.right==null)
            return trav.left;
        else
        {
        TreeNode lright = trav.left.right;

        TreeNode right = trav.right;

        trav=trav.left;
        TreeNode root=trav;
        trav.right=right;
        while(trav!=null && lright!=null)
        {
            if(trav.val >lright.val)
            {
                if(trav.left==null)
                {
                    trav.left=lright;
                    break;
                }
                trav=trav.left;
            }
            else
            {
                if(trav.right==null)
                {
                    trav.right=lright;
                    break;
                }
                trav=trav.right;
            }
        }
        return root;
    }
    
    }
}