class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        // 1. Build Adjacency List
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        // 2. BFS Setup
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        que.offer(source);
        visited[source] = true;

        // 3. Traverse
        while (!que.isEmpty()) {
            int ele = que.poll();
            
            if (ele == destination) return true;

            for (int neighbor : map.getOrDefault(ele, new ArrayList<>())) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    que.offer(neighbor);
                }
            }
        }

        return false;
    }
}