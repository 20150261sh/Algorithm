/* CRACKING the CODING INTERVIEW
2. Linked Lists */

import java.awt.List;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class LinkedList {
	private Node head = null;
	private Node tail = null;
	// private Node loop = null;
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
			System.out.print("Linked List is empty.");
			return;
		}
		// if (this.loop != null) {
		// this.printLoopList();
		// return;
		// }
		Node tmpNode = head;
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

	// void printLoopList() {
	// System.out.println("This List is Loop List");
	// Node tmpNode = head;
	// System.out.print("( ");
	// while (tmpNode != loop) {
	// System.out.print(tmpNode.data + " -> ");
	// tmpNode = tmpNode.next;
	// }
	// for(int i = 0; i < 3; i++) {
	// while(true) {
	// System.out.print(tmpNode.data + " -> ");
	// tmpNode = tmpNode.next;
	// if(tmpNode == loop)
	// break;
	// }
	// }
	// System.out.print(" ... )");
	// }

	int getSize() {
		return size;
	}

	void appendValToHead(int input) {
		Node newNode = new Node(input);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	void appendValToTail(int input) {
		Node newNode = new Node(input);

		if (size == 0)
			appendValToHead(input);
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}

	void appendNodeToHead(Node newNode) {
		if (newNode == null) {
			System.out.println("Input node is empty!");
			return;
		}
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}

	void appendNodeToTail(Node newNode) {
		if (newNode == null) {
			System.out.println("Input node is empty!");
			return;
		}
		if (size == 0)
			appendNodeToHead(newNode);
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	Node getNode(int findNum) {
		int i = 1;
		Node tmpNode = head;

		while (i != findNum) {
			i++;
			tmpNode = tmpNode.next;
		}
		return tmpNode;
	}

	void deleteNode(Node del) {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		if (del == head) {
			head = head.next;
			size--;
		} else if (del == tail) {
			Node tmpNode = head;
			while (tmpNode.next != tail)
				tmpNode = tmpNode.next;
			tmpNode.next = null;
			tail = tmpNode;
			size--;
		} else {
			Node tmpNode = head;
			while (del != tmpNode.next)
				tmpNode = tmpNode.next;
			tmpNode.next = tmpNode.next.next;
			size--;
		}
	}

	/*
	 * 2.1 Remove Dups! Write code to remove duplicates from an unsorted linked
	 * list. FOLLOW UP How would you solve this problem if a temporary buffer is not
	 * allowed?
	 */
	void deleteDupNode() {
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		Node tmpNode = this.head;
		while (tmpNode != null) {
			if (hash.containsKey(tmpNode.data)) {
				if (tmpNode.next != null) {
					Node tmp2 = tmpNode;
					tmpNode = tmpNode.next;
					this.deleteNode(tmp2);
				} else {
					this.deleteNode(tmpNode);
					tmpNode = null;
				}
			} else {
				hash.put(tmpNode.data, "YES");
				tmpNode = tmpNode.next;
			}
		}
	}

	/*
	 * 2.2 Return Kth to Last: Implement an algorithm to find the kth to last
	 * element of a singly linked list.
	 */
	void findKtoLastNode(int k) {
		Node tmpNode = head;
		int nodeIndex = 1;

		while (k != nodeIndex) {
			nodeIndex++;
			tmpNode = tmpNode.next;
		}
		while (tmpNode != null) {
			System.out.print(tmpNode.data + " ");
			tmpNode = tmpNode.next;
		}
		System.out.println();
	}

	/*
	 * 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle
	 * (i.e., any node but the first and last node, not necessarily the exact
	 * middle) of a singly linked list, given only access to that node.
	 */
	void deleteMidNode() {
		int size = this.getSize();
		Node[] nodeInfo = new Node[size];
		Random generator = new Random();
		int delIdx = generator.nextInt(size - 2) + 1;
		Node tmpNode = head;

		for (int i = 0; i < nodeInfo.length; i++) {
			nodeInfo[i] = tmpNode;
			if (tmpNode.next != null)
				tmpNode = tmpNode.next;
		}

		int count = 1;
		while (count != size - 1) {
			if (count == delIdx) {
				Node delNode = nodeInfo[count];
				this.deleteNode(delNode);
				break;
			}
			count++;
		}
	}

	/*
	 * 2.4 Partition: Write code to partition a linked list around a value x, such
	 * that all nodes less than x come before all nodes greater than or equal to x.
	 * If xis contained within the list, the values of x only need to be after the
	 * elements less than x (see below). The partition element x can appear anywhere
	 * in the "right partition"; it does not need to appear between the left and
	 * right partitions.
	 */
	void partition() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input x value: ");
		int x = scan.nextInt();
		Node tmpNode = head;

		while (tmpNode != null) {
			if (tmpNode.data < x) {
				Node delNode = tmpNode;
				int insert = delNode.data;
				tmpNode = tmpNode.next;
				this.deleteNode(delNode);
				this.appendValToHead(insert);
			} else
				tmpNode = tmpNode.next;
		}
	}

	/*
	 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each
	 * node contains a single digit. The digits are stored in reverse order, such
	 * that the 1 's digit is at the head of the list. Write a function that adds
	 * the two numbers and returns the sum as a linked list.
	 */
	static LinkedList sumLists(LinkedList l1, LinkedList l2) {
		if (l1 != null && l2 != null) {
			l1.printList();
			System.out.print(" + ");
			l2.printList();
			System.out.print(". That is, " + converToInt(l1) + " + " + converToInt(l2) + ".\n");
			int result = converToInt(l1) + converToInt(l2);
			return convertToList(result);
		} else {
			System.out.println("List must not be empty!");
			return null;
		}
	}

	static int converToInt(LinkedList l) {
		Node tmpNode = l.head;
		int result = 0, digit = 1;

		while (tmpNode != null) {
			result += digit * tmpNode.data;
			tmpNode = tmpNode.next;
			digit *= 10;
		}
		return result;
	}

	static LinkedList convertToList(int result) {
		LinkedList resList = new LinkedList();
		int length = (int) (Math.log10(result) + 1);
		int digit = 1;

		while (length > 1) {
			digit *= 10;
			length--;
		}

		while (true) {
			if (digit == 1) {
				resList.appendValToHead(result / digit);
				break;
			} else {
				resList.appendValToHead(result / digit);
				result = result % digit;
				digit /= 10;
			}
		}
		return resList;
	}

	/*
	 * 2.5 Sum Lists: You have two numbers represented by a linked list, where each
	 * node contains a single digit. The digits are stored in reverse order, such
	 * that the 1 's digit is at the head of the list. Write a function that adds
	 * the two numbers and returns the sum as a linked list. FOLLOW UP Suppose the
	 * digits are stored in forward order. Repeat the above problem.
	 */
	static LinkedList sumListsFollowUp(LinkedList l1, LinkedList l2) {
		if (l1 != null && l2 != null) {
			l1.printList();
			System.out.print(" + ");
			l2.printList();
			System.out.print(". That is, " + converToIntFollowUp(l1) + " + " + converToIntFollowUp(l2) + ".\n");
			int result = converToIntFollowUp(l1) + converToIntFollowUp(l2);
			return convertToListFollowUp(result);
		} else {
			System.out.println("List must not be empty!");
			return null;
		}
	}

	static int converToIntFollowUp(LinkedList l) {
		int count = 0, digit = 1, result = 0;
		Node tmpNode = l.head;

		while (tmpNode != null) {
			count++;
			tmpNode = tmpNode.next;
		}

		while (count > 1) {
			count--;
			digit *= 10;
		}
		tmpNode = l.head;
		while (tmpNode != null) {
			result += digit * tmpNode.data;
			tmpNode = tmpNode.next;
			digit /= 10;
		}
		return result;
	}

	static LinkedList convertToListFollowUp(int result) {
		LinkedList resList = new LinkedList();
		int length = (int) (Math.log10(result) + 1);
		int digit = 1;

		while (length > 1) {
			digit *= 10;
			length--;
		}

		while (true) {
			if (digit == 1) {
				resList.appendValToTail(result / digit);
				break;
			} else {
				resList.appendValToTail(result / digit);
				result = result % digit;
				digit /= 10;
			}
		}
		return resList;
	}

	/*
	 * 2.6 Palindrome: Implement a function to check if a linked list is a
	 * palindrome.
	 */
	public boolean palindrome() {
		if (this == null)
			return false;
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		Node tmpNode = head;
		int size = this.getSize();
		int mid1 = 0, mid2 = 0;
		int count = 0;

		if (size % 2 != 0) {
			mid1 = size / 2;
			while (count < mid1) {
				stack1.push(tmpNode.data);
				count++;
				tmpNode = tmpNode.next;
			}
			count++;
			tmpNode = tmpNode.next;
			int[] arr = new int[size - 1 - mid1];
			int i = 0;
			while (count < size) {
				arr[i] = tmpNode.data;
				i++;
				count++;
				tmpNode = tmpNode.next;
			}
			for (i = arr.length - 1; i > -1; i--)
				stack2.push(arr[i]);
		} else {
			mid2 = size / 2;
			mid1 = mid2 - 1;
			int cmp1 = 0, cmp2 = 0;
			while (count <= mid2) {
				if (count == mid1) {
					cmp1 = tmpNode.data;
				} else if (count == mid2) {
					cmp2 = tmpNode.data;
					break;
				}
				count++;
				tmpNode = tmpNode.next;
			}
			if (cmp1 != cmp2)
				return false;
			else {
				count = 0;
				tmpNode = head;
				while (count < mid1) {
					stack1.push(tmpNode.data);
					count++;
					tmpNode = tmpNode.next;
				}
				count += 2;
				tmpNode = tmpNode.next;
				tmpNode = tmpNode.next;
				int[] arr = new int[size - 1 - mid2];
				int i = 0;
				while (count < size) {
					arr[i] = tmpNode.data;
					i++;
					count++;
					tmpNode = tmpNode.next;
				}
				for (i = arr.length - 1; i > -1; i--)
					stack2.push(arr[i]);
			}
		}
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (stack1.pop() != stack2.pop())
				return false;
		}
		return true;
	}

	/*
	 * 2.7 Intersection: Given two (singly) linked lists, determine if the two lists
	 * intersect. Return the intersecting node. Note that the intersection is
	 * defined based on reference, not value. That is, if the kth node of the first
	 * linked list is the exact same node (by reference) as the jth node of the
	 * second linked list, then they are intersecting
	 */
	static Node intersection(LinkedList l1, LinkedList l2) {
		if (l1.tail == l2.tail) {
			if (l1.size == l2.size) {
				Node tmpNode1 = l1.head;
				Node tmpNode2 = l2.head;
				Node[] arr1 = new Node[l1.size];
				Node[] arr2 = new Node[l1.size];
				for (int i = 0; i < arr1.length; i++) {
					arr1[i] = tmpNode1;
					arr2[i] = tmpNode2;
					if (tmpNode1.next != null && tmpNode2.next != null) {
						tmpNode1 = tmpNode1.next;
						tmpNode2 = tmpNode2.next;
					}
				}

				for (int i = arr1.length - 1; i > -1; i--) {
					if (arr1[i] != arr2[i])
						return arr1[i + 1];
				}
			} else {
				int size = 0;
				if (l1.size > l2.size) {
					size = l1.size;
					Node tmpNode1 = l1.head;
					Node tmpNode2 = l2.head;
					Node[] arr1 = new Node[size];
					Node[] arr2 = new Node[size];
					int i, j;
					for (i = 0; i < arr1.length; i++) {
						arr1[i] = tmpNode1;
						if (tmpNode1.next != null)
							tmpNode1 = tmpNode1.next;
					}
					for (j = l2.size - 1; j < arr2.length; j++) {
						arr2[j] = tmpNode2;
						if (tmpNode2.next != null)
							tmpNode2 = tmpNode2.next;
					}
					i = arr1.length - 1;
					j = arr2.length - 1;
					while (i > -1 && j > -1) {
						if (arr1[i] != arr2[j])
							return arr1[i + 1];
						i--;
						j--;
					}
				} else {
					size = l2.size;
					Node tmpNode1 = l2.head;
					Node tmpNode2 = l1.head;
					Node[] arr1 = new Node[size];
					Node[] arr2 = new Node[size];
					int i, j;
					for (i = 0; i < arr1.length; i++) {
						arr1[i] = tmpNode1;
						if (tmpNode1.next != null)
							tmpNode1 = tmpNode1.next;
					}
					for (j = l1.size - 1; j < arr2.length; j++) {
						arr2[j] = tmpNode2;
						if (tmpNode2.next != null)
							tmpNode2 = tmpNode2.next;
					}
					i = arr1.length - 1;
					j = arr2.length - 1;
					while (i > -1 && j > -1) {
						if (arr1[i] != arr2[j])
							return arr1[i + 1];
						i--;
						j--;
					}
				}

			}
		} else {
			System.out.println("Not Intersection!");
			return null;
		}
		System.out.println("Not Intersection!");
		return null;
	}

	/*
	 * 2.8 Loop Detection: Given a circular linked list, implement an algorithm that
	 * returns the node at the beginning of the loop.
	 */
	void setListToCir() {
		Node loop = head;

		for (int i = 0; i < 2; i++)
			loop = loop.next;
		tail.next = loop;
	}

	Node detectLoop() {
		if (tail.next == null)
			return null;
		else
			return tail.next;
	}
	
	boolean HareAndTortoise() {
		Node hare = head;
		Node tor = head;
		
		while(hare != null && hare.next != null) {
			hare = hare.next.next;
			tor = tor.next;
			if(hare == tor)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list2 = new LinkedList();
		list2.appendValToTail(3);
		list2.appendValToTail(4);
		list2.appendValToTail(5);
		list2.appendValToTail(6);
		list2.appendValToTail(7);
		list2.appendValToTail(8);
		list2.printList();
		System.out.println();

		// LinkedList list1 = new LinkedList();
		// list1.appendValToTail(1);
		// list1.appendValToTail(2);
		// list1.appendNodeToTail(list2.getNode(1));
		// list1.appendNodeToTail(list2.getNode(2));
		// list1.appendNodeToTail(list2.getNode(3));
		// list1.printList();
		// System.out.println();

		/* 2.5 */
		// LinkedList resList = sumListsFollowUp(list1, list2);
		// resList.printList();
		// System.out.println(". That is, " + converToIntFollowUp(resList) + ".");

		/* 2.6 */
		// System.out.println(list1.palindrome());

		/* 2.7 */
		// Node res = null;
		// if ((res = intersection(list2, list1)) != null) {
		// System.out.println("Intersection node data is " + res.data);
		// } else
		// 
		
		/* 2.8 */
		// System.out.println("Set Loop List...(index: +2node)\n");
		// list2.setListToCir();
		// System.out.println("Node at the beginning of the loop is " +
		// list2.detectLoop().data);

	}
}
