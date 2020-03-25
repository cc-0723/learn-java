package 数据结构;

public class BSTree {
    //搜索树
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    private Node root = null;

    public Node find(int value) {
        if(root == null)
            return null;
        Node cur = root;
        while(cur != null) {
            if(cur.value == value)
                return cur;
            else if(cur.value > value)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return null;
    }

    public boolean insert(int value) {
        if(root == null){
            //空树，新建节点
            root = new Node(value);
            return true;
        }
        //非空，先搜索，在插入
        Node cur = root;
        Node parent = null;
        while(cur != null) {
            parent = cur;
            if(cur.value == value) {
                return false;
            }else if (cur.value > value) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        //找到一个合适的位置
        cur = new Node(value);
        if(parent.value > cur.value)
            parent.left = cur;
        else
            parent.right = cur;
        return true;
    }

    public void inOrder() {
        inOrderInternal(root);
        System.out.println();
    }

    private void inOrderInternal(Node root) {
        //中序遍历
        if(root != null) {
            inOrderInternal(root.left);
            System.out.print(root.value + " ");
            inOrderInternal(root.right);
        }
    }

public boolean remove(int value) {
    if(root == null)
        return false;
    Node cur = root;
    Node parent = null;
    while(cur != null){
        if(cur.value == value)
            break;
        else if(cur.value > value) {
            parent = cur;
            cur = cur.left;
        } else {
            parent = cur;
            cur = cur.right;
        }
    }
    //判断节点是否存在
    if(cur == null)
        return false;
    remove(parent, cur);
    return true;
    }

    public void remove(Node parent, Node cur) {
        if(cur.left == null) {
            if(cur != root) {
                if(parent.left == cur) {
                    parent.left = cur.right;
                } else {
                    parent.right = cur.right;
                }
            } else {
                root = cur.right;
            }
        } else if(cur.right == null) {
            if(cur != root) {
                if(parent.left == cur)
                    parent.left = cur.left;
                else
                    parent.right = cur.left;
            }
            else
                root = cur.left;
        } else {
            //左右子树都存在
            // 1. 找到左子树的最右节点
            // 2. 或者找到右子树的最左节点
            parent = cur;
            Node next = cur.left;
            //找到最右节点
            while(next.right != null) {
                parent = next;
                next = next.right;
            }
            //把最右节点的值赋给cur
            cur.value = next.value;
            //删除next
            if(parent.left == next)
                parent.left = next.left;
            else
                parent.right = next.left;
        }
    }
}

class Test {
    public static void main(String[] args) {
        BSTree bst = new BSTree();
        bst.insert(10);
        bst.insert(1);
        bst.insert(55);
        bst.insert(99);
        bst.insert(3);
        bst.insert(20);
        bst.insert(0);

        bst.inOrder();

        bst.remove(10);
        bst.inOrder();
    }
}
