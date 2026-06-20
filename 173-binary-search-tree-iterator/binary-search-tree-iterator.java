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
class BSTIterator {

    ArrayList<Integer> list;
    int list_ind;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        list_ind=0;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || nodeStack.isEmpty()==false){
            while(curr!=null){
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
    }
    
    public int next() {
        return list.get(list_ind++);
    }
    
    public boolean hasNext() {
        return list_ind<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */