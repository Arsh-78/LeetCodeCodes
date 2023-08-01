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
    
    class Pair{
        TreeNode node;
        int lev;
        Pair(TreeNode r , int l)
        {
            this.node = r;
            this.lev = l;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        
        Map<Integer,Integer> mp = new TreeMap<>();
        
        List<Integer> ans = new ArrayList<Integer>();
        inord(root,mp,0);
        for(Map.Entry<Integer,Integer> e : mp.entrySet())
        {
            ans.add(e.getValue());
        }
        return ans;
    }
    
    void inord(TreeNode root,Map<Integer,Integer> mp,int l)
    {
        if(root == null)
            return;
        inord(root.left,mp,l+1);
        if(mp.get(l) == null)
        {
            mp.put(l,root.val);
        }  
        else{
            mp.put(l,root.val);
        }
        inord(root.right,mp,l+1);
    }
}