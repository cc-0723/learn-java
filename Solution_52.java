class Solution {
    public void dfs(String tiles, StringBuilder curStr, List<Integer> prev, Set<String> str) {
        if(curStr.length() != 0) {
            str.add(curStr.toString());
        }
        for(int i = 0; i < tiles.length(); i++) {
            if(prev.get(i) == 1)
                continue;
            prev.set(i, 1);
            dfs(tiles, curStr.append(tiles.charAt(i)), prev, str);
            prev.set(i, 0);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }

    public int numTilePossibilities(String tiles) {
        if(tiles.length() == 0)
            return 0;
        StringBuilder curStr = new StringBuilder("");
        List<Integer> prev = new ArrayList<>();
        Set<String> str = new HashSet<>();
        for(int i = 0; i < tiles.length(); i++) {
            prev.add(0);
        }
        dfs(tiles, curStr, prev, str);
        return str.size();
    }
}