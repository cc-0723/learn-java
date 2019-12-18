package 数据结构.二叉树;

class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    }

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
        }
    }
}
