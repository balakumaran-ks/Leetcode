/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int idx;

    void helper(TreeNode node,ArrayList<Integer> list){
        if(node==null){
            list.add(null);
            return;
        }
        list.add(node.val);
        helper(node.left,list);
        helper(node.right,list);
    }

    // Encodes a tree to a single string.
    public ArrayList<Integer> serialize(TreeNode node) {
        ArrayList<Integer> list = new ArrayList<>();
        helper(node,list);
        return list;
    }

    public void buildTree(TreeNode node , ArrayList<Integer> list){
        if(node==null || idx>=list.size())return;
        if(list.get(idx)!=null){
            node.left = new TreeNode(list.get(idx++));
            buildTree(node.left,list);
        }else idx++;

        if(idx>=list.size())return;

        if(list.get(idx)!=null){
            node.right = new TreeNode(list.get(idx++));
            buildTree(node.right,list);
        }else idx++;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(ArrayList<Integer> list) {
        idx = 0;
        if(list.get(idx)==null)return null;
        TreeNode root = new TreeNode(list.get(idx++));
        buildTree(root,list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));