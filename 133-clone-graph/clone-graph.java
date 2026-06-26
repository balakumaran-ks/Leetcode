/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    public void dfs(Node node,Map<Integer,Node> nodeMap){
        if(nodeMap.containsKey(node.val))return;
        nodeMap.put(node.val,new Node(node.val));
        for(Node neighbor:node.neighbors){
            dfs(neighbor,nodeMap);
        }
    }

    public void bfs(Node node,Map<Integer,Node> nodeMap,Set<Node> visited){
        if(visited.contains(node))return;
        visited.add(node);
        Node cpy = nodeMap.get(node.val);
        for(Node neighbor:node.neighbors){
            cpy.neighbors.add(nodeMap.get(neighbor.val));
            bfs(neighbor,nodeMap,visited);
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null)return node;
        if(node.neighbors.size()==0)return new Node(node.val);
        Map<Integer,Node> nodeMap = new HashMap<>();
        dfs(node,nodeMap);
        Set<Node> visited = new HashSet<>();
        bfs(node,nodeMap,visited);
        return nodeMap.get(1);
    }
}