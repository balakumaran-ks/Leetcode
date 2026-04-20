class Solution {
    public int maxDistance(int[] colors) {
        //constraints are small -> n^3 is acceptable
        int n=colors.length;
        int res = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(colors[i]!=colors[j])
                res = Math.max(res , Math.abs(i-j));
                if(res==n-1)break;
            }
        }
        return res;
    }

}