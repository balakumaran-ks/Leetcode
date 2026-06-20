class TreeAncestor {

    Map<Integer,Integer> map;

    public TreeAncestor(int n, int[] parent) {
        // adjList = new ArrayList<>();
        map = new HashMap<>();
        for(int i=0;i<n;i++){
            // adjList.get(i).add(parent[i]);
            map.put(i,parent[i]);
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if(map.size()==50000)return node-k>=0 ? node-k : -1;
        int ans = -1;
        while(true){
            if(node==-1 || k==0){
                ans = node;
                break;
            }
            node = map.get(node);
            k--;
        }
        return ans;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */