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

    public void fillMap(TreeNode node, int level , Map<Integer,List<TreeNode>> map ){
        if(node==null)return;
        if(level%2==1){
            map.putIfAbsent(level,new ArrayList<TreeNode>());
            map.get(level).add(node);
        }
        fillMap(node.left,level+1,map);
        fillMap(node.right,level+1,map);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer,List<TreeNode>> map = new HashMap<>();
        fillMap(root,0,map);
        int level = 1;
        while(map.containsKey(level)){
            List<TreeNode> list = map.get(level);
            int l = 0;
            int r = list.size()-1;
            while(l<r){
                int temp = list.get(l).val;
                list.get(l).val = list.get(r).val;
                list.get(r).val = temp;
                l++;
                r--;
            }
            level+=2;
        }
        return root;
    }
}