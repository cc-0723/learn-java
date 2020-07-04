class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> tree = new ArrayList<>();
        if(root == null) 
            return tree;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> Floor = new ArrayList<>();
            while(size-- != 0) {
                Node node = q.peek();
                q.poll();
                Floor.add(node.val);
                for(Node child : node.children) {
                    if(child != null) 
                        q.offer(child);
                }
            }
            if(!Floor.isEmpty()) {
                tree.add(Floor);
            }
        }
        return tree;
    }
}