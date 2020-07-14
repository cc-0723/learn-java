class pair {
    public int x;
    public int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<pair>> solutions = new ArrayList<>();
        List<pair> solution = new ArrayList<>();
        nQueueBacktrack(solutions, solution, 0, n);
        return transResult(solutions, n);
    }

    void nQueueBacktrack(List<List<pair>> solutions, List<pair> solution, int curRow, int n) {
        if(curRow == n) {
            List<pair> newS = new ArrayList<>();
            for(pair p : solution) {
                newS.add(p);
            }
            solutions.add(newS);
        }
        for(int col = 0; col < n; col++) {
            if(isVlid(solution, curRow, col)) {
                solution.add(new pair(curRow, col));
                nQueueBacktrack(solutions, solution, curRow + 1, n);
                solution.remove(solution.size() - 1);
            }
        }
    }

    boolean isVlid(List<pair> solution, int row, int col) {
        for(pair p : solution){
            if(p.y == col || p.x + p.y == row + col || p.x - p.y == row - col)
                return false;
        }
        return true;
    }

    List<List<String>> transResult(List<List<pair>> solutions, int n) {
        List<String> tmp = new ArrayList<>();
        List<List<String>> ret = new ArrayList<>();
        for(List<pair> solution : solutions) {
            List<StringBuilder> solutionString = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++) {
                    sb.append('.');
                }
                solutionString.add(sb);
            }

            for(pair p : solution) {
                solutionString.get(p.x).setCharAt(p.y, 'Q');
            }
            List<String> curRet = new ArrayList<>();
            for(StringBuilder sb: solutionString) {
                curRet.add(sb.toString());
            }
            ret.add(curRet);
        }
        return ret;
    }
}