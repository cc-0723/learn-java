package 寒假练习;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_5 {
    //二叉树最大宽度
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        q.offer(root);
        list.add(1);
        int res = 1;
        while(!q.isEmpty()) {
            int count = q.size();
            for(int i = count; i > 0; i--) {
                TreeNode cur = q.poll();
                Integer cuiIndex = list.removeFirst();
                int curIndex = 0;
                if(cur.left != null) {
                    q.offer(cur.left);
                    list.add(curIndex * 2);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    list.add(curIndex * 2 +1);
                }
            }
            if(list.size() >= 2) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }
}
