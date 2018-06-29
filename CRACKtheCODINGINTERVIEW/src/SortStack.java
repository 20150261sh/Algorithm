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
				int sDel;
				while ((sDel = s.pop()) <= tmp.peek() || !tmp.isEmpty()) {
					s.push(tmp.pop());
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
		SStack s = new SStack(4);
		s.push(3);
		s.push(2);
		s.push(5);
		s.push(1020);
		s.printStack();
		sortStack(s);
		s.printStack();
	}

}
