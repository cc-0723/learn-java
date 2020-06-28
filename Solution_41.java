class Solution {
    public int DFS(Map<Integer, Employee> info, int id) {
        Employee curEm = info.get(id);
        int sum = curEm.importance;
        for(int curId : curEm.subordinates) {
            sum += DFS(info, curId);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        if(employees.isEmpty()) 
             return 0;
        Map<Integer, Employee> info = new HashMap<>();
        for(Employee e : employees) {
            info.put(e.id, e);
        }
        return DFS(info, id);
    }
}