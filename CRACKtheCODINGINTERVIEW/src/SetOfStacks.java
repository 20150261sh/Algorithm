/* CRACKING the CODING INTERVIEW
3. Stacks and Queues
3-3) Stack of Plates*/

import java.util.Scanner;

public class SetOfStacks {
	LinkedList setList = new LinkedList();
	private int stackNum = 0;

	public void print() {
		LinkedList.Node tmpNode = setList.tail;
		while (tmpNode.before != null) {
			tmpNode.spr.printStack();
			tmpNode = tmpNode.before;
		}
		tmpNode.spr.printStack();
	}

	public void push(int input) {
		if (setList.size == 0) {
			setList.appendToTail();
			stackNum++;
		}
		else if(setList.cur.spr.isFull()) {
			setList.appendToTail();
			stackNum++;
		}
		setList.cur.spr.push(input);
	}
	
	public int pop() {
		if (setList.size == 0) {
			System.out.println("All stack is empty");
			return -100000;
		} else {
			return setList.cur.spr.pop();
		}
	}
	
	/* FOLLOW UP: Implement a function popAt (int index) which performs a pop operation on a specific sub-stack. */
	public int popAt(int index) {
		int tmpNum = stackNum;
		LinkedList.Node tmpNode = setList.tail;
		
		while(tmpNum != index) {
			tmpNum--;
			tmpNode = tmpNode.before;
		}
		int del = tmpNode.spr.pop();
		return del;
	}
	
	public class LinkedList {
		private Node head = null;
		private Node tail = null;
		private Node cur = null;
		private int size = 0;

		private class Node {
			private Stack spr = null;
			private Node before = null;
			private Node next = null;

			public Node() {
				System.out.println("Input stack's capacity: ");
				Scanner scan = new Scanner(System.in);
				int capacity = scan.nextInt();
				Stack stack = new Stack(capacity);
				this.spr = stack;
			}
		}

		int getSize() {
			return size;
		}

		void appendToTail() {
			Node newNode = new Node();
			if (setList.size == 0) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				newNode.before = tail;
				tail = newNode;
			}
			cur = newNode;
			size++;
		}

		void deleteNode(Node del) {
			if (head == null) {
				System.out.println("Linked List is empty");
				return;
			}
			if (del == head) {
				head = head.next;
				head.before = null;
				size--;
			} else if (del == tail) {
				Node tmpNode = head;
				while (tmpNode.next != tail)
					tmpNode = tmpNode.next;
				tmpNode.next = null;
				tail.before = null;
				tail = tmpNode;
				size--;
			} else {
				Node tmpNode = head;
				while (del != tmpNode.next)
					tmpNode = tmpNode.next;
				tmpNode.next = tmpNode.next.next;
				tmpNode.next.next.before = tmpNode;
				size--;
			}
		}
	}

	private class Stack {
		private int capacity;
		private int top = -1;
		private int[] stackArr = null;

		Stack(int capacity) {
			stackArr = new int[capacity];
			this.capacity = capacity;
		}

		void printStack() {
			if (isEmpty()) {
				System.out.println("Stack is empty");
				return;
			} else {
				System.out.println("\n-----Print Stack-----");
				for (int i = top; i >= 0; i--) {
					System.out.println(stackArr[i]);
				}
				System.out.println("---------------------\n");
				return;
			}
		}

		boolean isFull() {
			if (top + 1 == capacity)
				return true;
			else
				return false;
		}

		boolean isEmpty() {
			if (top == -1)
				return true;
			else
				return false;
		}

		void push(int input) {
			if (isFull()) {
				System.out.println("Stack is full");
				return;
			} else {
				stackArr[++top] = input;
				return;
			}
		}

		int pop() {
			if (isEmpty()) {
				System.out.println("Stack is empty");
				return -10000;
			} else {
				int del = stackArr[top--];
				return del;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks set = new SetOfStacks();
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.print();
		set.popAt(1);
		set.print();
		set.popAt(2);
		set.print();
		set.popAt(3);
		set.print();
	}

}
