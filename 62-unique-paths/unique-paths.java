class Solution {
    public int uniquePaths(int m, int n) {
       int[][] path = new int[m][n];
       for(int ind=0;ind<n;ind++)path[0][ind]=1;
       for(int ind=0;ind<m;ind++)path[ind][0]=1;
       for(int row=1;row<m;row++){
        for(int col=1;col<n;col++){
            path[row][col] = path[row-1][col]+path[row][col-1];
        }
       } 
       return path[m-1][n-1];
    }
}