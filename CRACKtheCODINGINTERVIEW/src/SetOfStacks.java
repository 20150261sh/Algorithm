
/* CRACKING the CODING INTERVIEW
2. Linked Lists */

import java.awt.List;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
//import LinkedList.Node;

public class SetOfStacks {
	LinkedList setList = null;

	// SetOfStacks() {
	// }

	public void push(int input) {
		if (setList.size == 0)
			setList.appendToTail();
		else {
			setList.cur.spr.push(input);
		}
	}

	public int pop() {
		if (setList.size == 0) {
			System.out.println("All stack is empty");
			return -100000;
		} else {
			return setList.cur.spr.pop();
		}
	}

	// public boolean isEmpty() {
	// if(setList.head == null)
	// return true;
	// else
	// return false;
	// }

	public class LinkedList {
		private Node head = null;
		private Node tail = null;
		private Node cur = null;
		private int size = 0;

		private class Node {
			private Stack spr = null;
			private Node next = null;

			public Node() {
				System.out.println("Input stack's capacity: ");
				Scanner scan = new Scanner(System.in);
				int capacity = scan.nextInt();
				Stack stack = new Stack(capacity);
				this.spr = stack;
				this.next = null;
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
				tail = newNode;
			}
			cur = newNode;
			size++;
		}

	}

	private class Stack {
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
			if (isFull()) {
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

		int pop() {
			if (isEmpty()) {
				System.out.println("Stack is empty");
				return -10000;
			}
			int del = top.data;
			top = top.next;
			size--;
			return del;
		}

		boolean isEmpty() {
			if (size == 0)
				return true;
			else
				return false;
		}

		boolean isFull() {
			if (size == capacity)
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks set = new SetOfStacks();
		set.push(1);
		set.push(2);
		set.push(3);
	}

}
