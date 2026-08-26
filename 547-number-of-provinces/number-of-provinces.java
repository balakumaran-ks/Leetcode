class Solution {

    public void dfs(int u , int[][] adj , boolean[] visited){
        for(int i=0;i<adj.length;i++){
            if(!visited[i] && adj[u][i]==1){
                visited[i] = true;
                dfs(i,adj,visited);
            }
        }
    } 

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,isConnected,visited);
                res++;
            }
        }
        return res;
    }
}