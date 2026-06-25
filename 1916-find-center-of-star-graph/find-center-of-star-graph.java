class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+2;
        int[] count = new int[n];
        for(int[] edge:edges){
            count[edge[0]]++;
            count[edge[1]]++;
        }
        int res = 0;
        for(int i=1;i<n;i++){
            if(count[i]==n-2)res = i;
        }
        return res;
    }
}