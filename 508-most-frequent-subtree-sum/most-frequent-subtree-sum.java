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
    public int helper(TreeNode node, Map<Integer,Integer> map){
        if(node==null)return 0;
        int left = helper(node.left,map);
        int right = helper(node.right,map);
        int sum = node.val+left+right;
        map.putIfAbsent(sum,0);
        map.put(sum,map.get(sum)+1);
        return sum;
    }   

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);

        // 1. Find the maximum frequency
        int maxFreq = 0;
        for (int freq : map.values()) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        // 2. Collect all subtree sums with that maximum frequency
        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                resList.add(entry.getKey());
            }
        }
        
        // 3. Convert the List to an int[] array to match the return type
        int[] result = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            result[i] = resList.get(i);
        }
        
        return result;
    }
}