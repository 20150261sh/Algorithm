/* CRACKING the CODING INTERVIEW
2. Linked Lists
2-1) Remove Dups: Write code to remove duplicates from an unsorted linked list. */

public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}
	
	void print() {
		Node head = this;
		System.out.println("# Print linked list");
		while(head != null) {
			System.out.print(head.data);
			if(head.next != null)
				System.out.print(" -> ");
			head = head.next;
		}
		System.out.println("\n");
	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	Node deleteNode(Node n, int d) {
		Node del = n;

		if (del.data == d) {
			return n.next;
		}

		while (del != null) {
			if (del.next.data == d) {
				del.next = del.next.next;
				return n;
			}
			del = del.next;
		}
		return n;
	}
	
	Node deleteDups() {
		Node n = this;
		int size = getSize(n);
		int k = 0;
		int []arr = new int[size];
		int newSize = 0;
		boolean check = false;
		
		while(n != null) {
			for(int j = 0; j < arr.length; j++) {
				if(n.data == arr[j])
					check = true;
			}
			if(!check) {
				arr[k] = n.data;
				k++;
				newSize++;
			}
			else 
				check = false;
			n = n.next;
		}
		
		for(int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
		System.out.println();

		System.out.println("new size = " + newSize);
		
		Node delDups = new Node(arr[0]);
		for(int i = 1; i < newSize; i++) {
			delDups.appendToTail(arr[i]);
		}
		return delDups;
	}
	
	int getSize(Node n) {
		int size = 0;
		
		while(n != null) {
			size++;
			n = n.next;
		}
		return size;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.appendToTail(4);
		n.appendToTail(2);
		n.appendToTail(11);
		n.appendToTail(3);
		n.appendToTail(2);
		n.appendToTail(4);
		n.appendToTail(3);
		n.appendToTail(5);
		n.print();
		Node delDups = n.deleteDups();
		delDups.print();
		// TODO Auto-generated method stub
	}

}
