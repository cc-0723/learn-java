class Solution {
    int[][] nextPosition = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(char[][] grid, int row, int col, int[][] book, int i, int j) {
        book[i][j] = 1;
        for(int k = 0; k < 4; k++) {
            int ni = i + nextPosition[k][0];
            int nj = j + nextPosition[k][1];
            if(ni < 0 || ni >= row || nj < 0 || nj >= col) 
                continue;
            if(grid[ni][nj] == '1' && book[ni][nj] == 0) {
                dfs(grid, row, col, book, ni, nj);
            }
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        int[][] book = new int[row][col];

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1' && book[i][j] == 0) {
                    count++;
                    dfs(grid, row, col, book, i, j);
                }
            }
        }
        return count;
    }
}