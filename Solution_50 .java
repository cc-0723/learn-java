class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public void backTrace(String digits, List<String> ret, StringBuilder curStr, int depth) {
        if(depth == digits.length()) {
            if(curStr.length() != 0) {
                ret.add(curStr.toString());
            }
            return;
        }
        
        int cur = digits.charAt(depth) - '0';
        String curMap = map[cur];
        for(int i = 0; i < curMap.length(); i++) {
            backTrace(digits, ret, curStr.append(curMap.charAt(i)), depth + 1);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        StringBuilder curStr = new StringBuilder("");
        backTrace(digits, ret, curStr, 0);
        return ret;
    }
}