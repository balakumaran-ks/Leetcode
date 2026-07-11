import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // 1. Build the adjacency list and track degrees
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        // 2. Track visited nodes using a 1D array
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> componentNodes = new ArrayList<>();
                // Find all nodes belonging to the current connected component
                dfs(i, adj, visited, componentNodes);
                
                // 3. Check if the component is complete
                boolean isComplete = true;
                int totalNodes = componentNodes.size();
                for (int node : componentNodes) {
                    // Every node in a complete component must have a degree equal to (V - 1)
                    if (degree[node] != totalNodes - 1) {
                        isComplete = false;
                        break;
                    }
                }
                
                if (isComplete) {
                    completeComponents++;
                }
            }
        }
        
        return completeComponents;
    }
    
    private void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> componentNodes) {
        visited[node] = true;
        componentNodes.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, componentNodes);
            }
        }
    }
}