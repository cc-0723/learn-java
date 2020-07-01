class Solution {
    //顺时针方向更新
    int[][] nextPosition = {{0, 1}, {1, 0}, {-1, 0} ,{0, -1}};
    public void dfs(char[][] board, int row, int col, int i, int j) {
        board[i][j] = 'A';
        for(int k = 0; k < 4; k++) {
            int ni = i + nextPosition[k][0];
            int nj = j + nextPosition[k][1];
            if(ni < 0 || ni >= row || nj < 0 || nj >= col)
                continue;
            if(board[ni][nj] != 'A' && board[ni][nj] != 'X'){
                dfs(board, row, col, ni, nj);
            }
        }
    }

    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        int row = board.length;
        int col = board[0].length;

        //第一行和最后一行
        for(int i = 0; i < col; i++) {
            if(board[0][i] == 'O')
                dfs(board, row, col, 0, i);
            if(board[row - 1][i] == 'O')
                dfs(board, row, col, row - 1, i);
        }

        for(int i = 0; i < row; i++) {
            if(board[i][0] == 'O')
                dfs(board, row, col, i, 0);
            if(board[i][col - 1] == 'O')
                dfs(board, row, col, i, col - 1);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'A')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}