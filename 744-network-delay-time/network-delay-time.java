class Solution {

    public void dfs(int[][] adj , int u , int[] dist){
        for(int v=0;v<adj[u].length;v++){
            if(adj[u][v]!=-1 && dist[v]>dist[u]+adj[u][v]){
                dist[v] = Math.min(dist[v],dist[u]+adj[u][v]);
                dfs(adj,v,dist);
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[k] = 0;
        int[][] adj = new int[n+1][n+1];
        for(int[] a:adj)Arrays.fill(a,-1);
        for(int[] edge:times){
            adj[edge[0]][edge[1]] = edge[2];
        }
        dfs(adj , k , dist);
        int res = Integer.MIN_VALUE;
        for(int d=1;d<=n;d++){
            if(dist[d]==Integer.MAX_VALUE)return -1;
            res = Math.max(res,dist[d]);
        }
        return res;
    }
}