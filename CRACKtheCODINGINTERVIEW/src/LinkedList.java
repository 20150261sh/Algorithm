
public class LinkedList {
	private Node head = null;
	private Node tail = null;
	private int size = 0;

	private class Node {
		private int data;
		private Node next;
		
		public Node(int input) {
			this.data = input;
			this.next = null;
		}
	}

	void printList() {
		if (head == null) {
			System.out.println("Linked List is empty.");
			return;
		}
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	
	void appendToHead(int input) {
		Node newNode = new Node(input);

		newNode.next = head;
		head = newNode;
		size++;
	}

	void appendToTail(int input) {
		Node newNode = new Node(input);

		if (size == 0)
			appendToHead(input);
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
