class Solution {
    public int edgeScore(int[] edges) {
        long[] nodescores = new long[edges.length];

        //finding all nodescores
        for(int label=0;label<edges.length;label++){
            if(edges[label]!=-1)nodescores[edges[label]]+=(long)label;
        }

        //finding maximum or maximum with smallest index
        int res = 0;
        for(int label = 0;label<edges.length;label++){
            if(nodescores[label]>nodescores[res])res=(int)label;
        }

        return res;
    }
}