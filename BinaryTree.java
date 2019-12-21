package 数据结构.二叉树;

 class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        left = right = null;
    }
 }

public class BinaryTree {
    public static int size = 0;
    public static int leafSize = 0;

     //前序遍历
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历
    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.left);
            System.out.print(root.value);
            inOrder(root.right);
        }
    }

    //后序遍历
    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.value);
        }
    }

    //得到结点个数
    public void getSize1(Node root) {
        if(root != null) {
            getSize1(root.left);
            getSize1(root.right);
            size++;
        }
    }

    //得到结点个数 = 左子树结点个数 + 右子树结点个数 + 根结点
    public int getSize2(Node root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return getSize2(root.left) + getSize2(root.right) + 1;
    }

    //得到叶子结点的个数
    public void getLeafSize1(Node root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
         leafSize++;
         return;
        }
        getLeafSize1(root.left);
        getLeafSize1(root.right);
    }

    //得到叶子结点的个数 = 左子树叶子结点个数 + 右子树叶子结点个数
    public int getLeafSize2(Node root) {
        if(root ==null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }

    //得到k层的结点个数
    public int getKSize(Node root, int k) {
        if(root ==null)
            return 0;
        if(k == 1)
            return 1;
        return getKSize(root.left,k - 1) + getKSize(root.right,k - 1);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        Node node1 = new Node('B');
        Node node2 = new Node('C');
        Node node3 = new Node('D');
        Node node4 = new Node('E');
        Node node5 = new Node('F');
        Node node6 = new Node('G');
        Node node7 = new Node('H');

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.right = node7;

        BinaryTree btree = new BinaryTree();
        System.out.println("前序遍历结果为：");
        btree.preOrder(root);
        System.out.println();
        System.out.println("中序遍历结果为：");
        btree.inOrder(root);
        System.out.println();
        System.out.println("后序遍历结果为：");
        btree.postOrder(root);
        System.out.println();
        System.out.println("----------");
        btree.getSize1(root);
        System.out.println(BinaryTree.size);
        System.out.println(btree.getSize2(root));
        btree.getLeafSize1(root);
        System.out.println(BinaryTree.leafSize);
        System.out.println(btree.getLeafSize2(root));
        System.out.println("----------");
        System.out.println(btree.getKSize(root,1));
        System.out.println(btree.getKSize(root,2));
        System.out.println(btree.getKSize(root,3));
        System.out.println(btree.getKSize(root,4));

    }
}
