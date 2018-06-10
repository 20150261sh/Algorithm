/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-2) Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.  */

public class Stack {
	private int capacity;
	private int size = 0;
	private Node top = null;
	
	Stack(int capacity) {
		this.capacity = capacity;
	}
	
	private class Node {
		private int data;
		private Node next;

		public Node(int input) {
			this.data = input;
			this.next = null;
		}
	}
	
	void printStack() {
		if (isEmpty()) {
			System.out.print("Stack is empty.");
			return;
		}
		Node tmpNode = top;
		System.out.print("( ");
		while (tmpNode != null) {
			if (tmpNode.next != null)
				System.out.print(tmpNode.data + " -> ");
			else
				System.out.print(tmpNode.data + " ");
			tmpNode = tmpNode.next;
		}
		System.out.print(")");
	}
	
	void push(int input) {
		if(isFull()) {
			System.out.print("Stack is full.");
			return;
		}
		Node newNode = new Node(input);
		if (size == 0) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
		size++;
	}
	
	void pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		top = top.next;
		size--;
	}
		
	
	boolean isEmpty() {
		if(size == 0)
			return true;
		else 
			return false;
	}
	
	boolean isFull() {
		if(size == capacity) 
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack = new Stack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.printStack();
		System.out.println();
	}

}
