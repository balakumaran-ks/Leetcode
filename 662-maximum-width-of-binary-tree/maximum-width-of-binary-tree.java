class Solution {
    // Helper class to tie a node to its heap-indexed position
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0)); // Root starts at index 0
        int max = 0;
        
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            
            // The boundary indices for the current level
            int firstIdx = queue.peekFirst().index;
            int lastIdx = queue.peekLast().index;
            
            // Calculate width using the indices directly
            max = Math.max(max, lastIdx - firstIdx + 1);
            
            for (int i = 0; i < qSize; i++) {
                Pair curr = queue.poll();
                TreeNode node = curr.node;
                int currIdx = curr.index;
                
                // Only add real, existing children (no null-padding needed!)
                if (node.left != null) {
                    queue.add(new Pair(node.left, 2 * currIdx));
                }
                if (node.right != null) {
                    queue.add(new Pair(node.right, 2 * currIdx + 1));
                }
            }
        }
        return max;
    }
}