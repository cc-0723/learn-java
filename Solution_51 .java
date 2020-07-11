class Solution {
    public void dfs(int[] candidates, List<List<Integer>> retMat, List<Integer> solution, int curSum, int prev, int target) {
        if(curSum >= target) {
            if(curSum == target) {
                List<Integer> s = new ArrayList<>();
                for(int i : solution)
                    s.add(i);
                retMat.add(s);
            }
            return;
        }

        for(int i = prev; i < candidates.length; i++) {
            if(curSum > target)
                continue;
            solution.add(candidates[i]);
            dfs(candidates, retMat, solution, curSum + candidates[i], i, target);
            //回溯
            solution.remove(solution.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> retMat = new ArrayList<>();
        List<Integer> solution = new ArrayList<>();
        if(candidates.length == 0)
            return retMat;
        int curSum = 0;
        dfs(candidates, retMat, solution, curSum, 0, target);
        return retMat;
    }
}