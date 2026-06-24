class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0]>target || matrix[m-1][n-1]<target)return false;
        int row = 0;
        while(row<m && matrix[row][0]<target){
            row++;
        }
        if(row>=m)row--;
        if(matrix[row][0]==target)return true;
        if(matrix[row][0]>target)row--;
        if(row<0)return false;
        for(int num:matrix[row]){
            if(num==target)return true;
        }
        return false;
    }
}