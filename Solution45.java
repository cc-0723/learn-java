public static void prOrderNoR(Node root){
	//前序非递归遍历树
	Stack<Node> st = new Stack<>();
	Node curNode = root;
	
	while(!Stack.isEmpty() || curNode != null) {
		while(curNode != null) {
			system.out.println(curNode.val + " ");
			st.push(curNode);
			curNode = curNode.left;
		}
		curNode = st.pop();
		curNode = curNode.right;
	}
}

//递归前序遍历
public static void prOrder(Node root) {
	if(root != null) {
		system.out.println(root.val);
		prOrder(root.left);
		prOrder(root.right);
	}
}

public static void inOrderNoR(Node root) {
	//中序非递归遍历
	Stack<Node> st = new Stack<>();
	Node curNode = root;
	
	while(curNode != null || !st.isEmpty()) {
		while(curNode != null) {
			//先访问左
			st.push(curNode);
			curNode = curNode.left;
		}
		//访问根
		curNode = st.pop();
		system.out.println(curNode.val);
		//右
		curNode = curNode.right;
	}
}

//递归中序遍历
public static void inOrder() {
	if(root != null) {
		inOrder(root.left);
		system.out.println(root.val);
		inOrder(root.right);
	}
}

//后序非递归
public static void postOrderNoR(Node root) {
	Stack<Node> st = new Stack<>();
	Node curNode = root;
	Node prev = null;
	
	while(curNode != null || !st.isEmpty()) {
		while(curNode != null) {
			st.push(curNode);
			curNode = curNode.left;
		}
		    curNode = st.peek();
		//访问右子树的两种情况
		//1.右子树为空
		//2.上次访问的节点为右子树，否则访问右子树
		if(curNode.right = null || curNode.right == prev) {
			system.out.println(curNode.val);
			prev = curNode;
			st.pop();
			curNode = null;
		}else {
			curNode = curNode.right;
		}
	}
}

//后序递归
public static void postOrder(Node root) {
	if(root != null) {
		postOrder(root.left);
		postOrder(root.right);
		system.out.println(root.val);
	}
}









