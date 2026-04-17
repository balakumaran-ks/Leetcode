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
    public int minDepth(TreeNode node) {
        if(node==null)return 0;
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(node);
        while(q.isEmpty()==false){
            int level = q.size();
            for(int i=0;i<level;i++){
                TreeNode proc = q.poll();
                if(proc.left==null && proc.right==null)return depth+1;
                if(proc.left!=null)q.offer(proc.left);
                if(proc.right!=null)q.offer(proc.right);
            }
            depth++;
        }
        return depth+1;
    }
}