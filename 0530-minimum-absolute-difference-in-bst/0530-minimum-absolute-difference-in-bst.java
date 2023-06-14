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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> trav = new ArrayList<>();

        inOrd(root,trav);

        int min =Integer.MAX_VALUE;
        for(int i=0;i<trav.size()-1;i++)
        {
            if(Math.abs(trav.get(i)-trav.get(i+1))<min)
            {
                min = Math.abs(trav.get(i)-trav.get(i+1));
            }
        }
        return min;
    }

    public void inOrd(TreeNode root,ArrayList<Integer> trav)
    {
        if(root==null)
        {
            return ;
        }
        inOrd(root.left,trav);
        trav.add(root.val);
        inOrd(root.right,trav);

    }
}