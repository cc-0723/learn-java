class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String de : deadends) {
            set.add(de);
        }
        if(set.contains("0000"))
            return -1;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        Set<String> book = new HashSet<>();
        book.add("0000");

        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String cur = q.peek();
                q.poll();
                if(cur.equals(target))
                    return step;
                for(int j = 0; j < 4; j++) {
                    char ch1 = cur.charAt(j);
                    char ch2 = cur.charAt(j);
                    if(ch1 == '9')
                        ch1 = '0';
                    else 
                        ch1++;
                    if(ch2 == '0')
                        ch2 = '9';
                    else 
                        ch2--;
                    StringBuilder str1 = new StringBuilder(cur);
                    StringBuilder str2 = new StringBuilder(cur);
                    str1.setCharAt(j, ch1);
                    str2.setCharAt(j, ch2);
                    if(!set.contains(str1.toString()) && !book.contains(str1.toString())) {
                        q.offer(str1.toString());
                        book.add(str1.toString());
                    }
                    if(!set.contains(str2.toString()) && !book.contains(str2.toString())) {
                        q.offer(str2.toString());
                        book.add(str2.toString());
                    }
                }
            }
            step++;
        }
        return -1;
    }
}