import java.util.Scanner;

/* CRACKING the CODING INTERVIEW
1. Arrays and Strings
1-8) Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0. */

public class ZeroMatrix {
	public static int[][] zeroMatrix(int[][] arr, int row, int col) {
		int[][] res = new int[row][col];
		boolean[][] check = new boolean[row][col];

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++)
				check[i][j] = false;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (arr[i][j] == 0 && !check[i][j]) {
					res[i][j] = 0;
					check[i][j] = true;
					for (int k = 0; k < col; k++) {
						if (!check[i][k]) {
							res[i][k] = 0;
							check[i][k] = true;
						}
					}
					for (int k = 0; k < row; k++) {
						if (!check[k][j]) {
							res[k][j] = 0;
							check[k][j] = true;
						}
					}
				} else if (arr[i][j] != 0 && !check[i][j])
					res[i][j] = arr[i][j];
			}

		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Input row size: ");
		int row = scan.nextInt();
		System.out.print("Input colum size: ");
		int col = scan.nextInt();
		int[][] array = new int[row][col];

		System.out.print("\nInput array: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				array[i][j] = scan.nextInt();
		}

		System.out.println("# Original array");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(array[i][j] + " ");
			System.out.println();
		}

		int[][] res = zeroMatrix(array, row, col);

		System.out.println("\n# Zero array");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}

}
