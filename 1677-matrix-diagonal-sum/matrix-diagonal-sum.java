class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int row=0;
        for(row=0;row<mat.length;row++){
            sum+= (mat[row][row]+mat[row][mat.length-row-1]);
        }
        if(mat.length%2==1)sum-=mat[row/2][row/2];
        return sum;
    }
}