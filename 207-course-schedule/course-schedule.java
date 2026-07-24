class Solution {
    public boolean canFinish(int n, int[][] edges) {
        if(edges.length==0)return true;
        List<Integer>[] adjList = new ArrayList[n];
        int[] indeg = new int[n];
        for(int i=0;i<n;i++)adjList[i]=new ArrayList<>();
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList[u].add(v);
            indeg[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int res = 0;
        for(int i=0;i<n;i++)if(indeg[i]==0)queue.add(i);

        while(!queue.isEmpty()){
            int u = queue.poll();
            res++;
            for(int v:adjList[u]){
                if(--indeg[v]==0)queue.add(v);
            }
        }
        return res==n;
    }
}