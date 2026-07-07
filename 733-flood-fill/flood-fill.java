class Solution {

    public void bfs(int[][] image,boolean[][] visited, int r, int c, int color,int ori){
        if(r<0 || c<0 || r>=image.length || c>=image[0].length || image[r][c]!=ori || visited[r][c])return;
        image[r][c] = color;
        visited[r][c] = true;
        bfs(image,visited , r+1,c,color,ori);
        bfs(image,visited , r-1,c,color,ori);
        bfs(image,visited , r,c+1,color,ori);
        bfs(image,visited , r,c-1,color,ori);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] visited = new boolean[n][m];
        bfs(image,visited,sr,sc,color,image[sr][sc]);
        return image;
    }
}