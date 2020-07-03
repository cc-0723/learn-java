class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        while(!q.isEmpty()) {
            int p = q.peek();
            q.poll();
            count += map.get(p).importance;
            for(int num : map.get(p).subordinates) {
                q.offer(num);
            }
        }
        return count;
    }
}