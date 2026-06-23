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

class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode root,int idx){
        node=root;
        index=idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,0));

        while(queue.isEmpty()==false){
            int qSize = queue.size();

            int firstIndex = queue.peekFirst().index;
            int lastIndex = queue.peekLast().index;

            max = Math.max(max,lastIndex-firstIndex+1);

            for(int i=0;i<qSize;i++){
                TreeNode curr = queue.peek().node;
                int currIndex = queue.peek().index;
                queue.poll();
                if(curr.left!=null){
                    queue.add(new Pair(curr.left , 2*currIndex));
                }
                if(curr.right!=null){
                    queue.add(new Pair(curr.right , 2*currIndex+1));
                }
            }
        }
        return max;
    }
}