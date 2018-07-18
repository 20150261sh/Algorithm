
public class BSTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree bst = new BSTree();
		bst.insertBST(12);
		bst.insertBST(5);
		bst.insertBST(15);
		bst.insertBST(3);
		bst.insertBST(7);
		bst.insertBST(13);
		bst.insertBST(17);
		bst.insertBST(16);
		bst.insertBST(19);
//		bst.printBST();
//		System.out.println(bst.root.data);
//		System.out.println(bst.root.left.data);
//		System.out.println(bst.root.left.left.data);
//		System.out.println(bst.root.left.right.data);
//		System.out.println(bst.root.right.data);
//		System.out.println(bst.root.right.right.data);
//		System.out.println(bst.root.right.right.left.data);
//		System.out.println(bst.root.right.right.right.data);
		bst.deleteNode(12);
		bst.deleteNode(5);
		System.out.println("val " + bst.root.left.data);
	}

}
