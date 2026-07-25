class Solution {
    int[][] memo = new int[201][201];
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int dfs(int[][] adj , int r , int c,int m,int n){
        if(memo[r][c]!=0)return memo[r][c];
        memo[r][c]=1;
        for(int d=0;d<4;d++){
            int nr = r + dx[d];
            int nc = c + dy[d];
            if(nr>=0 && nr < m && nc>=0 && nc < n && adj[nr][nc]>adj[r][c]){
                memo[r][c] = Math.max(memo[r][c],1+dfs(adj,nr,nc,m,n));
            }
        }
        return memo[r][c];
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = -1;
        // for(int[] mem:memo)
        // Arrays.fill(mem,-1);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res = Math.max(res , dfs(matrix,i,j,m,n));
            }
        }    
        return res;
    }
}