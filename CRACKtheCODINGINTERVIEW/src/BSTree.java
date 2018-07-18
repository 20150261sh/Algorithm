public class BSTree {
	TreeNode root = null;
	int number = 0;

	void printBST() {
		preorder(root);
		System.out.println();
	}
	
	boolean IsNoChild(TreeNode targetNode) {
		if(targetNode.left == null && targetNode.right == null)
			return true;
		else 
			return false;
	}

	TreeNode insertKey(TreeNode root, int input) {
		TreeNode tmpNode = root;
		TreeNode newNode = new TreeNode(input);
		if (tmpNode == null)
			return newNode;
		else if (tmpNode.data > newNode.data) {
			tmpNode.left = insertKey(tmpNode.left, input);
			return tmpNode;
		} else if (tmpNode.data < newNode.data) {
			tmpNode.right = insertKey(tmpNode.right, input);
			return tmpNode;
		} else
			return tmpNode;
	}

	void insertBST(int input) {
		if (root == null) {
			root = new TreeNode(input);
			number++;
			return;
		}
		root = insertKey(root, input);
		number++;
	}

	void deleteNode(int delVal) {
		int count = 0;
		TreeNode tmpNode = root;
		TreeNode parentNode = tmpNode;
		TreeNode delNode = null;

		// 삭제할 노드 탐색
		while (true) {
			if (tmpNode.data == delVal) {
				delNode = tmpNode;
				break;
			}
			if (tmpNode.data > delVal) {
				if (count > 0)
					parentNode = tmpNode;
				if(IsNoChild(tmpNode)) {
					System.out.println("The delVal is not exist.");
					return;
				}
				tmpNode = tmpNode.left;
				count++;
			} else if (tmpNode.data < delVal) {
				if (count > 0)
					parentNode = tmpNode;
				if(IsNoChild(tmpNode)) {
					System.out.println("The delVal is not exist.");
					return;
				}
				tmpNode = tmpNode.right;
				count++;
			}
		}
	
		System.out.println("delNode value is " + delNode.data);
		// 실제 삭제
		if (delNode.left == null && delNode.right == null) { // 자식이 없는 노드 삭제
			if (parentNode.left.data == delNode.data)
				parentNode.left = null;
			else
				parentNode.right = null;
		} else if (delNode.left == null || delNode.right == null) { // 자식 1개
			if (delNode.left != null) {
				if (parentNode.left == delNode)
					parentNode.left = delNode.left;
				else if (parentNode.right == delNode)
					parentNode.right = delNode.left;
			} else if (delNode.right != null) {
				if (parentNode.left == delNode)
					parentNode.left = delNode.right;
				else if (parentNode.right == delNode)
					parentNode.right = delNode.right;
			}

		} else if (delNode.left != null && delNode.right != null) { // 자식 2개
			tmpNode = delNode.right;
			if (parentNode.data == delNode.data) {
				if (tmpNode.left != null) {
					TreeNode child = tmpNode.left;
					if (delNode.left.data < child.data) {
						tmpNode.left = delNode.left;
						if(tmpNode.left.right != null) {
							if(tmpNode.left.right.data < child) {
								
							}
						}
						else
							tmpNode.left.right = child;
					}
				} else {
					tmpNode.left = root.left;
				}
				root = tmpNode;
			} else if (parentNode.left == delNode) {
				parentNode.left = tmpNode;
			} else if (parentNode.right == delNode) {
				parentNode.right = tmpNode;
			}
			if (tmpNode.left != null) {
				TreeNode child = tmpNode.left;
				if (delNode.left.data < child.data) {
					tmpNode.left = delNode.left;
					tmpNode.left.right = child;
				} else
					child.right = delNode.left;
			}
		}
	}

	void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}
}