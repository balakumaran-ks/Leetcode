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

    public void fill(TreeNode node,int level , Map<Integer,List<Integer>> map){
        if(node==null)return;
        if(map.containsKey(level)==false)map.put(level , new ArrayList<Integer>());
        map.get(level).add(node.val);
        fill(node.left,level+1,map);
        fill(node.right,level+1,map);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)return res;
        Map<Integer,List<Integer>> map = new HashMap<>();
        int level = 0;
        fill(root,level,map);
        while(map.containsKey(level)){
            res.add(map.get(level++));
        }
        return res;
    }
}