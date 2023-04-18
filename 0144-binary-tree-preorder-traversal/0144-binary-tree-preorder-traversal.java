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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        ArrayList<Integer> fans = new ArrayList<>();
        st.push(root);
        
        while(!st.isEmpty())
        {
            TreeNode temp = st.pop();
            if(temp != null)
            {
                fans.add(temp.val);
                st.add(temp.right);
                st.add(temp.left);
            }
        }
        return fans;
    }
}