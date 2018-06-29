/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-5) Sort Stack: Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.*/

class SStack {
	int capacity;
	int top = -1;
	int[] sArr;

	SStack(int capacity) {
		this.capacity = capacity;
		sArr = new int[capacity];
	}

	void printStack() {
		System.out.println("------Print Stack-------");
		for (int i = top; i > -1; i--) {
			System.out.println(sArr[i]);
		}
		System.out.println();
	}

	boolean isEmpty() {
		if (top == -1)
			return true;
		else
			return false;
	}

	int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -10000;
		}
		return sArr[top];
	}

	void push(int input) {
		if (top + 1 == capacity) {
			System.out.println("Stack is full");
			return;
		}
		sArr[++top] = input;
	}

	int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -10000;
		}
		return sArr[top--];
	}
}

public class SortStack {
	static void sortStack(SStack s) {
		SStack tmp = new SStack(s.capacity);
		while (!s.isEmpty()) {
			if (tmp.isEmpty())
				tmp.push(s.pop());
			else {
				int sDel = s.pop();
				while (true) {
					if(tmp.isEmpty())
						break;
					if(sDel <= tmp.peek()) 
						s.push(tmp.pop()); 
					else
						break;
				}
				tmp.push(sDel);
			}
		}
		while (!tmp.isEmpty()) {
			s.push(tmp.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SStack s = new SStack(8);
		s.push(3);
		s.push(2);
		s.push(5);
		s.push(1020);
		s.push(1);
		s.push(445);
		s.push(12);
		s.push(30);
		s.printStack();
		sortStack(s);
		s.printStack();
	}

}
