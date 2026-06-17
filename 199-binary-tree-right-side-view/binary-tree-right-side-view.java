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

    public void fill(TreeNode node , int level , Map<Integer,Integer> map){
        if(node==null)return;
        if(map.containsKey(level)==false){
            map.put(level,node.val);
        }
        fill(node.right , level+1 , map);
        fill(node.left , level+1 , map);
    }

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        fill(root , 0 , map);
        int level = 0;
        List<Integer> res = new ArrayList<>();
        while(map.containsKey(level)){
            res.add(map.get(level++));
        }
        return res;
    }
}