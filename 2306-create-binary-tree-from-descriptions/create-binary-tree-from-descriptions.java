class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        // Change this set to strictly keep track of nodes that are children
        Set<Integer> children = new HashSet<>();
        
        for (int[] r : descriptions) {
            map.computeIfAbsent(r[0], k -> new TreeNode(r[0]));
            map.computeIfAbsent(r[1], k -> new TreeNode(r[1]));
            
            if (r[2] == 1) {
                map.get(r[0]).left = map.get(r[1]);
            } else {
                map.get(r[0]).right = map.get(r[1]);
            }
            
            // Track that this node is definitely a child
            children.add(r[1]);
        }
        
        // Find the root: it's a parent node that is NEVER in the children set
        for (int[] r : descriptions) {
            if (!children.contains(r[0])) {
                return map.get(r[0]);
            }
        }
        
        return null;
    }
}