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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.isEmpty()==false){
            int qSize = queue.size();
            long sum = 0;
            for(int i=0;i<qSize;i++){
                TreeNode curr = queue.poll();
                sum+=curr.val;
                if(curr.left!=null)queue.add(curr.left);
                if(curr.right!=null)queue.add(curr.right);
            }
            res.add((double)sum/(double)qSize);
        }
        return res;
    }
}