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
    public int longestZigZag(TreeNode root) {
        
        TreeNode curr =root;
        
        int ans=helper(curr,0,0,0);
        return ans;
        
    }
    public int helper(TreeNode curr,int direction,int len,int maxLength)
    {
        if(curr==null)
        {
            if(len>maxLength)
            {
                maxLength=len;
            }
            return maxLength;
        }
        else
        {
            if(direction==0)
            {
                
                int l=helper(curr.left,-1,len,maxLength);
                int r=helper(curr.right,1,len,maxLength);
                if(maxLength<l || maxLength<r)
                {
                    maxLength = l>r?l:r;
                }
                return maxLength;
                
            }
            else if(direction==-1)
            {
                len++;
                int r = helper(curr.right,1,len,maxLength);
                int l= helper(curr.left,-1,0,maxLength);
                if(l>maxLength || r>maxLength)
                {
                    maxLength= l>r?l:r;
                }
                return maxLength;
            }
            else
            {
                len++;
                int l = helper(curr.left,-1,len,maxLength);
                int r = helper(curr.right,1,0,maxLength);
                if(l>maxLength || r>maxLength)
                {
                    maxLength= l>r?l:r;
                }
                return maxLength;
            }
        }
        
    }
}