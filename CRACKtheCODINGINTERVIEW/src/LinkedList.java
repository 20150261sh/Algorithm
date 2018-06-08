import java.awt.List;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import java.util.Scanner;

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
			System.out.print("Linked List is empty.");
			return;
		}
		Node tmpNode = head;
		System.out.print("( ");
		while (tmpNode != null) {
			if(tmpNode.next != null)
				System.out.print(tmpNode.data + " -> ");
			else
				System.out.print(tmpNode.data + " ");
			tmpNode = tmpNode.next;
		}
		System.out.print(")");
	}

	int getSize() {
		return size;
	}

	void appendToHead(int input) {
		Node newNode = new Node(input);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
			Node tmpNode = head;
			while (tmpNode.next != null)
				tmpNode = tmpNode.next;
			tail = tmpNode;
		}
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
	
	Node getNode(int findNum) {
		int i = 1;
		Node tmpNode = head;
		
		while(i != findNum) {
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

	/* 2.1 Remove Dups! Write code to remove duplicates from an unsorted linked list. 
	 * FOLLOW UP How would you solve this problem if a temporary buffer is not allowed? */
	void deleteDupNode() {
		Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
		Node tmpNode = this.head;
		while(tmpNode != null) {
			if (hash.containsKey(tmpNode.data)) { 
				if(tmpNode.next != null) {
					Node tmp2 = tmpNode;
					tmpNode = tmpNode.next;
					this.deleteNode(tmp2);
				}
				else {
					this.deleteNode(tmpNode);
					tmpNode = null;
				}
			}
			else { 
				hash.put(tmpNode.data, "YES");
				tmpNode = tmpNode.next;
			}
		}
	}
	
	/* 2.2 Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list. */
	void findKtoLastNode(int k) {
		Node tmpNode = head;
		int nodeIndex = 1;
		
		while(k != nodeIndex) {
			nodeIndex++;
			tmpNode = tmpNode.next;
		}
		while(tmpNode != null) {
			System.out.print(tmpNode.data + " ");
			tmpNode = tmpNode.next;
		}
		System.out.println();
	}
	
	/* 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle 
	 * (i.e., any node but the first and last node, not necessarily the exact middle) 
	 * of a singly linked list, given only access to that node. */
	void deleteMidNode() {
		int size = this.getSize();
		Node[] nodeInfo = new Node[size];
		Random generator = new Random();   
		int delIdx = generator.nextInt(size-2) + 1;
		Node tmpNode = head;
		
		for(int i = 0; i < nodeInfo.length; i++) {
			nodeInfo[i] = tmpNode;
			if(tmpNode.next != null)
				tmpNode = tmpNode.next;
		}
		
		int count = 1;
		while(count != size - 1) {
			if(count == delIdx) {
				Node delNode = nodeInfo[count];
				this.deleteNode(delNode);
				break;
			}
			count++;
		}
	}
	
	/* 2.4 Partition: 
	 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If xis contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions. */
	void partition() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input x value: ");
		int x = scan.nextInt();
		Node tmpNode = head;
		
		while(tmpNode != null) {
			if(tmpNode.data < x) {
				Node delNode = tmpNode;
				int insert = delNode.data;
				tmpNode = tmpNode.next;
				this.deleteNode(delNode);
				this.appendToHead(insert);
			}
			else 
				tmpNode = tmpNode.next;
		} 
	}
	
	/* 2.5 Sum Lists: 
	 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list. */
	static LinkedList sumLists(LinkedList l1, LinkedList l2) {
		l1.printList();
		System.out.print(" + ");
		l2.printList();
		System.out.print(". That is, " + converToInt(l1) + " + " + converToInt(l2) + ".\n");
		int result = converToInt(l1) + converToInt(l2);
		return convertToList(result);
	}
	
	static int converToInt(LinkedList l) {
		Node tmpNode = l.head;
		int result = 0, digit = 1;
		
		while(tmpNode != null) {
			result += digit * tmpNode.data;
			tmpNode = tmpNode.next;
			digit *= 10;
		}
		return result;
	}
	
	static LinkedList convertToList(int result) {
		LinkedList resList = new LinkedList();
		int length = (int)(Math.log10(result) + 1);
		int digit = 1;
		
		while(length > 1) {
			digit *= 10;
			length--;
		}
		
		while(true) {
			if(digit == 1) {
				resList.appendToHead(result/digit);
				break;
			}
			else {
				resList.appendToHead(result/digit);
				result = result % digit;
				digit /= 10;
			}
		}
		return resList;
	}
	
	/* 2.5 Sum Lists: 
	 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list. 
	 * FOLLOW UP Suppose the digits are stored in forward order. Repeat the above problem. */
	static LinkedList sumListsFollowUp(LinkedList l1, LinkedList l2) {
		l1.printList();
		System.out.print(" + ");
		l2.printList();
		System.out.print(". That is, " + converToIntFollowUp(l1) + " + " + converToIntFollowUp(l2) + ".\n");
		int result = converToIntFollowUp(l1) + converToIntFollowUp(l2);
		return convertToListFollowUp(result);
	}
	
	static int converToIntFollowUp(LinkedList l) {
		int count = 0, digit = 1, result = 0;
		Node tmpNode = l.head;
		
		while(tmpNode != null) {
			count++;
			tmpNode = tmpNode.next;
		}
		
		while(count > 1) {
			count--;
			digit *= 10;
		}
		tmpNode = l.head;
		while(tmpNode != null) {
			result += digit * tmpNode.data;
			tmpNode = tmpNode.next;
			digit /= 10;
		}
		return result;
	}
	
	static LinkedList convertToListFollowUp(int result) {
		LinkedList resList = new LinkedList();
		int length = (int)(Math.log10(result) + 1);
		int digit = 1;
		
		while(length > 1) {
			digit *= 10;
			length--;
		}
		
		while(true) {
			if(digit == 1) {
				resList.appendToTail(result/digit);
				break;
			}
			else {
				resList.appendToTail(result/digit);
				result = result % digit;
				digit /= 10;
			}
		}
		return resList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list1 = new LinkedList();
		list1.appendToTail(6);
		list1.appendToTail(1);
		list1.appendToTail(7);
		
		LinkedList list2 = new LinkedList();
		list2.appendToTail(2);
		list2.appendToTail(9);
		list2.appendToTail(5);
		
//		list1.printList();
//		System.out.println();
//		list2.printList();
//		System.out.println();
		
		LinkedList resList = sumListsFollowUp(list1, list2);
		resList.printList();
		System.out.println(". That is, " + converToIntFollowUp(resList) + ".");
	}

}
