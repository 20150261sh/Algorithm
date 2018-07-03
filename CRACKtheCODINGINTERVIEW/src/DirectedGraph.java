/* CRACKING the CODING INTERVIEW
4. Trees and Graphs
4-1) Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes. 
(1) Use adjacency matrix*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DirectedGraph {
	static int v;
	static int e;
	static int[][] array;

	static void setArray() {
		array = new int[v][v];
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++)
				array[i][j] = 0;
		}
	}

	static void printArray() {
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
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
		
		if(array[n1-1][n2-1] == 1)
			return true;
		else 
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
					array[i - 1][j - 1] = 1;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printArray();
		System.out.println(routeNode());
	}

}
