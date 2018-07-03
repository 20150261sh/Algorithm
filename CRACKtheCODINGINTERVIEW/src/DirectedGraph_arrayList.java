
/* CRACKING the CODING INTERVIEW
4. Trees and Graphs
4-1) Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes. 
(2) Use adjacency list*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DirectedGraph_arrayList {
	static int v;
	static int e;
	static ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>>ArrayList();

	static void setArray() {
		for (int i = 0; i < v; i++)
			list.add(new <Integer>ArrayList());
	}

	static void printList() {
		for (int i = 0; i < v; i++) {
			Iterator<Integer> iter = list.get(i).iterator();
			System.out.print("node " + (i + 1));
			if (iter.hasNext())
				System.out.print(": ");
			while (iter.hasNext())
				System.out.print(iter.next() + " -> ");
			System.out.println("x");
		}
		System.out.println();
	}

	static boolean routeNode() {
		Scanner scan = new Scanner(System.in);

		System.out.println("-----Consider node's direct-----");
		System.out.println("# Input node1's number: ");
		int n1 = scan.nextInt();
		System.out.println("# Input node2's number: ");
		int n2 = scan.nextInt();
		System.out.println("Node " + n1 + " ->" + " " + n2 + " 's route: ");

		Iterator<Integer> iter = list.get(n1-1).iterator();
		while (iter.hasNext()) {
			if(n2 == iter.next()) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader("/Users/songhee/Desktop/input.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String s = null;
		int count = 0;
		try {
			while ((s = input.readLine()) != null) {
				count++;
				if (count == 1)
					v = Integer.parseInt(s);
				else if (count == 2)
					e = Integer.parseInt(s);
				else {
					if (count == 3)
						setArray();
					String[] line = s.split(" ");
					int i = Integer.parseInt(line[0]);
					int j = Integer.parseInt(line[1]);
					list.get(i-1).add(j);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printList();
		System.out.println(routeNode());
	}

}
