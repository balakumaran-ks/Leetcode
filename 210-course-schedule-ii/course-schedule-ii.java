class Solution {
    public int[] findOrder(int n, int[][] edges) {
        int[] res = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        int[] indeg = new int[n];
        for(int i=0;i<n;i++)adjList[i]=new ArrayList<>();
        for(int[] edge:edges){
            int u = edge[1];
            int v = edge[0];
            adjList[u].add(v);
            indeg[v]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        int num = 0;
        for(int i=0;i<n;i++)if(indeg[i]==0)queue.add(i);
        int index = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            res[index++]=u;
            num++;
            for(int v:adjList[u]){
                if(--indeg[v]==0)queue.add(v);
            }
        }
        if(num!=n){
            return new int[]{};
        }
        return res;
        
    }
}