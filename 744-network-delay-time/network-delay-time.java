import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build adjacency list: node -> list of (neighbor, weight)
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : times) {
            adj.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[]{edge[1], edge[2]});
        }

        // 2. Distance array initialized to infinity
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 3. Min-Heap storing pairs: {current_distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int d = current[0];
            int u = current[1];

            // If we found a shorter path to u already, skip
            if (d > dist[u]) continue;

            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.offer(new int[]{dist[v], v});
                    }
                }
            }
        }

        // 4. Find max signal propagation time
        int maxDelay = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // Unreachable node
            maxDelay = Math.max(maxDelay, dist[i]);
        }

        return maxDelay;
    }
}