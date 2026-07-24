class Solution {

    int[] color;

    public boolean dfs(int[][] graph , int u ){
        color[u] = 1;
        int n = graph.length;
        for(int v:graph[u]){
            if(color[v]==1)return false;
            if(color[v]==0 && !dfs(graph,v))return false;
        }
        color[u] = 2;
        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(color[i]==0)dfs(graph , i);
            if(color[i]==2)res.add(i);
        }
        return res;
    }
}