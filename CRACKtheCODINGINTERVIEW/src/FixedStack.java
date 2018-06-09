/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-1) Three in One: Describe how you could use a single array to implement three stacks. */

public class FixedStack {
	private int capacity;
	private static int[] top = {0, -1, -1, -1};
	private static int[] base = {0, -1, -1, -1};
	private int[] full;
	private static int[] stack;
	
	public FixedStack(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		full = new int[4];
		full[0] = 0;
		full[1] = capacity/3 - 1;
		full[2] = 2*capacity/3 - 1;
		full[3] = capacity - 1;
	}

	public int push(int stackNum, int item) {
		if(!isFull(stackNum)) {
			if(top[stackNum] == -1) {
				if(stackNum == 1) {
					top[stackNum]++;
					base[stackNum]++;
					stack[top[stackNum]] = item;
				}
				else if(stackNum == 2) {
					top[stackNum] = capacity/3;
					base[stackNum] = capacity/3;
					stack[top[stackNum]] = item;
				}
				else if(stackNum == 3) {
					top[stackNum] = 2*capacity/3;
					base[stackNum] = 2*capacity/3;
					stack[top[stackNum]] = item;
				}
			}
			else {
				stack[++top[stackNum]] = item;
			}
			return item;
		}
		else {
			System.out.println("push: " + stackNum + " Stack is full");
			return -10000000;
		}
	}

	public int pop(int stackNum) {
		if(!isEmpty(stackNum)) {
			int item = stack[top[stackNum]--];
			if(top[stackNum] < base[stackNum])
				top[stackNum] = -1;
			return item;
		}
		else {
			System.out.println("pop: " + stackNum + " Stack is empty");
			return -100000000;
		}
	}

	public int peek(int stackNum) {
		if(!isEmpty(stackNum)) {
			return stack[top[stackNum]];
		}
		else {
			System.out.println("peek: " + stackNum + " Stack is empty");
			return -10000000;
		}
	}

	public boolean isEmpty(int stackNum) {
		if(top[stackNum] == -1)
			return true;
		else
			return false;
	}

	public boolean isFull(int stackNum) {
		if(top[stackNum] == full[stackNum])
			return true;
		else 
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FixedStack fs1 = new FixedStack(10);
		fs1.push(1, 444);
		fs1.push(1, 2);
		fs1.push(1, 3);
		fs1.push(1,  111);
		fs1.push(2,  222);
		fs1.push(3,  333);
		fs1.push(3,  555);
		fs1.push(3,  666);
		fs1.push(3,  21200);
		fs1.push(3,  21300);
		System.out.println("----------------------------");
		for(int i = 0; i < 10; i++)
			System.out.println(stack[i]);
		System.out.println(fs1.peek(1));
		System.out.println(fs1.peek(2));
		System.out.println(fs1.peek(3));
	};

}