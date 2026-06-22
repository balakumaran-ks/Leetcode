class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        int n = traversal.length();
        
        while (i < n) {
            // 1. Count the depth (number of dashes)
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            
            // 2. Extract the node value
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            
            // Create the current node
            TreeNode node = new TreeNode(val);
            
            // 3. Move up the tree if the stack is too deep
            while (stack.size() > depth) {
                stack.pop();
            }
            
            // 4. Connect to the parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            
            // 5. Push current node to stack for its potential children
            stack.push(node);
        }
        
        // The bottom-most element in the stack is the root
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.peek();
    }
}