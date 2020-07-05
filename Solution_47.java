class pair {
    public int x;
    public int y;
    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                if(grid[i][j] == 0)
                    q.offer(new pair(i, j));
            }
        }

        int[][] nextPosition = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int minute = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            int flag = 0;
            while(size-- != 0) {
                pair cur = q.peek();
                q.poll();
                for(int i = 0; i < 4; i++) {
                    int nx = cur.x + nextPosition[i][0];
                    int ny = cur.y + nextPosition[i][1];
                    if(nx < 0 || nx >= row || ny < 0 || ny >= col)
                        continue;
                    flag = 1;
                    grid[nx][ny] = 2;
                    q.offer(new pair(nx, ny));
                }
            }
            if(flag == 1)
                minute++;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0 ; j < col; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return minute;
    }
}