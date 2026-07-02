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

    public void buildParentMap(TreeNode node,Map<TreeNode,TreeNode> parentMap,Queue<TreeNode> queue,int start){
        if(node==null)return;
        if(node.val==start)queue.add(node);
        if(node.left!=null){
            parentMap.put(node.left,node);
            buildParentMap(node.left,parentMap,queue,start);
        }
        if(node.right!=null){
            parentMap.put(node.right,node);
            buildParentMap(node.right,parentMap,queue,start);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        if(root.left==null && root.right==null)return 0;
        int minutes = -1;
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        parentMap.put(root,null);
        buildParentMap(root,parentMap,queue,start);
        while(queue.isEmpty()==false){
            minutes++;
            int qSize = queue.size();
            for(int i=0;i<qSize;i++)
            {
            TreeNode curr = queue.poll();
            visited.add(curr);
            if(curr.left!=null && visited.contains(curr.left)==false)queue.add(curr.left);
            if(curr.right!=null && visited.contains(curr.right)==false)queue.add(curr.right);
            if(parentMap.get(curr)!=null && visited.contains(parentMap.get(curr))==false)queue.add(parentMap.get(curr));
        }
        }
        return minutes;
    }
}