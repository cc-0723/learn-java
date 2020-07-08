class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String wd : wordList) {
            set.add(wd);
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- != 0) {
                String cur = q.peek();
                q.poll();
                for(int i = 0; i < cur.length(); i++) {
                    StringBuilder word = new StringBuilder(cur);
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        word.setCharAt(i, ch);
                        String change = word.toString();
                        if(!set.contains(change) || visited.contains(change)) 
                            continue;
                        if(change.equals(endWord))
                            return res + 1;
                        visited.add(change);
                        q.offer(change);
                    }
                }
            }
            res++;
        }
        return 0;
    }
}