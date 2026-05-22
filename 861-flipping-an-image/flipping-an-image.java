class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                res[i][n-j-1]=image[i][j]^1;
            }
        }
        return res;
    }
}