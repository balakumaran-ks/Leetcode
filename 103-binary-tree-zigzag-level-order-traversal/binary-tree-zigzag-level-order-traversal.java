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

    public void fill(TreeNode node , int level , List<List<Integer>> list){
        if(node==null)return;
        if(level==list.size())list.add(new ArrayList<Integer>());
        list.get(level).add(node.val);
        fill(node.left,level+1,list);
        fill(node.right,level+1,list);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int level = 0;
        fill(root,level,res);
        while(level<res.size()){
            if(level%2==1)Collections.reverse(res.get(level));
            level++;
        }
        return res;
    }
}