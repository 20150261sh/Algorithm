import java.util.Scanner;

/* CRACKING the CODING INTERVIEW
1. Arrays and Strings
1-6) String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z). */

public class Compression {
	public static String compress(String input) {
		char ch, nch;
		int count = 0;
		System.out.print("Compress String is: ");
		for(int i = 0; i < input.length(); i++) {
			count = 0;
			ch = input.charAt(i);
			count++;
			while(true) {
				if(i + 1 >= input.length()) {
					System.out.print(ch);
					System.out.print(count);
					break;
				}
				nch = input.charAt(++i);
				if(ch == nch)
					count++;
				else {
					System.out.print(ch);
					System.out.print(count);
					i--;
					break;
				}
			}
		}
		return input;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input string: ");
		String input = scan.nextLine();
		System.out.println("\n\nOriginal String is: " + compress(input));
	}

}
