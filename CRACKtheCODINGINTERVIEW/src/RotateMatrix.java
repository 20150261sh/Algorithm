import java.util.Scanner;

/* CRACKING the CODING INTERVIEW
1. Arrays and Strings
1-7) Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */

public class RotateMatrix {
	public static void rotate(int[][] a, int n) {
		int i = 0, j = 0, k = 0, l = n - 1;
		int[][] b = new int[n][n];
		while(l >= 0) {
			if(j < n) {
				b[k][l] = a[i][j];
				j++;
				k++;
			}
			else {
				i++;
				j = 0;
				k = 0;
				l--;
			}
		}
		System.out.println("Rotate matrix a: \n");
		for(i = 0; i < b.length; i++) {
			for(j = 0; j < b.length; j++) {
				if(b[i][j] < 10)
					System.out.print(b[i][j] + "   ");
				else if(b[i][j] < 100)
					System.out.print(b[i][j] + "  ");
				else if(b[i][j] < 1000)
					System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input size: ");
		int n = scan.nextInt();
		int[][] a = new int[n][n];
		int num = 1;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) 
				a[i][j] = num++;
		}
		System.out.println("Original matrix a: \n");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if(a[i][j] < 10)
					System.out.print(a[i][j] + "   ");
				else if(a[i][j] < 100)
					System.out.print(a[i][j] + "  ");
				else if(a[i][j] < 1000)
					System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
		rotate(a, n);
	}

}
