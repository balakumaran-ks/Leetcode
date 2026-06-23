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

    public void helper(TreeNode node , StringBuilder sb){
        if(node==null){
            sb.append("null-");
            return;
        }
        sb.append(node.val);
        sb.append('-');
        helper(node.left,sb);
        helper(node.right,sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }

    int idx;

    public void buildTree(TreeNode node,ArrayList<Integer> list){
        if(node==null || idx>=list.size())return;
        if(list.get(idx)!=null){
            node.left = new TreeNode(list.get(idx++));
            buildTree(node.left , list);
        }else idx++;

        if(idx>=list.size())return;

        if(list.get(idx)!=null){
            node.right = new TreeNode(list.get(idx++));
            buildTree(node.right , list);
        }else idx++;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String d) {
        String[] data = d.split("-"); 
        ArrayList<Integer> list = new ArrayList<>();
        for(String node:data){
            if(node.equals("null"))list.add(null);
            else list.add(Integer.parseInt(node));
        }
        if(list.get(0)==null)
        return null;
        TreeNode root = new TreeNode(list.get(0));
        idx = 1;
        buildTree(root,list);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;