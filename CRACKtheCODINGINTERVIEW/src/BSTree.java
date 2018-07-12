
public class BSTree {
	TreeNode root = null;

	void printBST() {
		preorder(root);
		System.out.println();
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
			return;
		}
		root = insertKey(root, input);
	}

	void deleteNode(int delVal) {
		int count = 0;
		TreeNode tmpNode = root;
		TreeNode parentNode = tmpNode;
		TreeNode delNode = null;
		while (tmpNode.data != delVal) {
			if (tmpNode.data > delVal) {
				if(count > 0)
					parentNode = tmpNode;
				tmpNode = tmpNode.left;
				count++;
			} else if (tmpNode.data < delVal) {
				if(count > 0)
					parentNode = tmpNode;
				tmpNode = tmpNode.right;
				count++;
			} else {
				delNode = tmpNode;
				break;
			}
			if (tmpNode.left == null || tmpNode.right == null) {
				System.out.println("The delVal is not exist.");
				return;
			}
		}
		if (delNode.left == null && delNode.right == null) {
			if(parentNode.left.data == delNode.data)
				parentNode.left = null;
			else 
				parentNode.right = null;
		} else {
			if (delNode.left != null && delNode.left != null) {
				
			} else {
				
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
}
