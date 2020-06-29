class Solution {
    int[][] nextPosition = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public void dfs(int[][] image, int row, int col, int[][] book, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        book[sr][sc] = 1;
        for(int i = 0; i < 4; i++) {
            int newSr = sr + nextPosition[i][0];
            int newSc = sc + nextPosition[i][1];
            if(newSr < 0 || newSr >= row || newSc < 0 || newSc >= col)
                continue;
            if(image[newSr][newSc] == oldColor && book[newSr][newSc] == 0) {
                dfs(image, row, col, book, newSr, newSc,oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int row = image.length;
        int col = image[0].length;
        int[][] book = new int[row][col];
        dfs(image, row, col, book, sr, sc, oldColor, newColor);
        return image;
    }
}