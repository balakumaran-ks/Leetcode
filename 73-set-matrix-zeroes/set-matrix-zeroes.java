class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        while(rows.isEmpty()==false){
            int row = rows.poll();
            for(int i=0;i<n;i++)matrix[row][i]=0;
        }
        while(cols.isEmpty()==false){
            int col = cols.poll();
            for(int i=0;i<m;i++)matrix[i][col]=0;
        }
    }
}