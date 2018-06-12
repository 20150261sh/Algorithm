
/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-4) Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks. */

import java.util.Stack;

public class MyQueue {
	private Stack<Integer> stack_origin = null;
	private Stack<Integer> stack_check = null;
	private int capacity = 0;

	MyQueue(int capacity) {
		this.capacity = capacity;
		stack_origin = new Stack<Integer>();
		stack_check = new Stack<Integer>();
	}

	int getSize() {
		return stack_origin.size();
	}

	boolean isFull() {
		if (capacity == stack_origin.size())
			return true;
		else
			return false;
	}

	boolean isEmpty() {
		if (stack_origin.size() == 0)
			return true;
		else
			return false;
	}

	void enQueue(int data) {
		if (!isFull()) {
			stack_origin.push(data);
		} else
			System.out.println("Queue is full!");
	}

	void deQueue() {
		if (!isEmpty()) {
			while (!isEmpty()) {
				stack_check.push(stack_origin.pop());
			}
			stack_check.pop();
			//int count = 0;
			while (!stack_check.isEmpty()) {
				//count++;
				stack_origin.push(stack_check.pop());
			}
		} else
			System.out.println("Queue is empty!");
	}

	int peek() {
		if (!isEmpty()) {
			while (!isEmpty()) {
				stack_check.push(stack_origin.pop());
			}
			int result = stack_check.pop();
			while (!stack_check.isEmpty()) {
				stack_origin.push(stack_check.pop());
			}
			return result;
		} else {
			System.out.println("Queue is empty!");
			return -1000000;
		}
	}

	void printQueue() {
		if (!isEmpty()) {
			while (!isEmpty()) {
				stack_check.push(stack_origin.pop());
			}
			// int count = 0;
			int result = 0;
			System.out.println("Print Queue");
			while (!stack_check.isEmpty()) {
				result = stack_check.pop();
				System.out.print(result + " ");
				stack_origin.push(result);
			}
			System.out.print("\n");
		} else
			System.out.println("Queue is empty!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue my = new MyQueue(5);
		my.enQueue(1);
		my.enQueue(2);
		my.enQueue(3);
		my.enQueue(4);
		my.enQueue(5);
		my.printQueue();
		my.deQueue();
		my.deQueue();
		my.printQueue();
		System.out.println("First elemeent is " + my.peek());
		my.printQueue();
		System.out.println("Queue size is " + my.getSize());
	}

}
