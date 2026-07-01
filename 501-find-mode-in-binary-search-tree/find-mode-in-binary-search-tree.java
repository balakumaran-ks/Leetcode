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

    public void fill(TreeNode node,Map<Integer,Integer> map){
        if(node==null)return;
        fill(node.left,map);
        map.put(node.val,map.getOrDefault(node.val,0)+1);
        fill(node.right,map);
    }

    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        fill(root,map);
        int maxElCount = 0;
        int max = 0;
        for(int val:map.values()){
            if(val>max){
                max=val;
                maxElCount = 1;
            }
            else if(val==max){
                maxElCount++;
            }
        }
        int[] res = new int[maxElCount];
        int index = 0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()==max){
                res[index++] = m.getKey();
            }
        }
        return res;
    }
}