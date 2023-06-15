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
    public int maxLevelSum(TreeNode root) {

    

     List<Integer> fans = new ArrayList<Integer>();
     fans.add(0);
     fans = levOrd(root,fans);
     int maxIndex=0;
     
     for(int i=0;i<fans.size()-1;i++)
     {
         if(fans.get(maxIndex)<fans.get(i))
         {
             maxIndex=i;
         }
     }
     return maxIndex+1;

    }


    public List<Integer> levOrd(TreeNode root,List<Integer> fans )
    {
        if(root==null)
        {
            return fans;
        }

        TreeNode trav = root;    
         Queue<TreeNode> q = new LinkedList<>();
        q.add(trav);
        int s= q.size();
        int i=0;
        while(!q.isEmpty())
        {
            TreeNode n = q.poll();
            s--;
            if(n.left!= null)
            {
                q.offer(n.left);
            }
            if(n.right!=null)
            {
                q.offer(n.right);
            }

            int sum = fans.get(i) + n.val;
            fans.set(i,sum);

            if(s==0)
            {
                s=q.size();
                i++;
                fans.add(0);
            }

        }  
        return fans;

    }
}