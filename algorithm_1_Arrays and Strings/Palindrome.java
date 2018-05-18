/* CRACKING the CODING INTERVIEW
1. Arrays and Strings
1-4) Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin­ drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. */

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Palindrome {

	public static void palindrome(String input) {
//		Hashtable<String, Integer> h = new Hashtable<String, Integer>();
//		for (int i = 0; i < input.length(); i++) {
//			if (h.containsKey(input.substring(i, i + 1))) {
//				int tmp = h.get(input.substring(i, i + 1));
//				h.put(input.substring(i, i + 1), ++tmp);
//			} else {
//				h.put(input.substring(i, i + 1), 1);
//			}
//		}
//		int first, and;
//		Enumeration keys2 = h.keys();
//		String key2 = (String) keys2.nextElement();
//		first = h.get(key2);
//		if (input.length() % 2 == 0) {
//			Enumeration keys1 = h.keys();
//			while (keys1.hasMoreElements()) {
//				String key1 = (String) keys1.nextElement();
//				and = h.get(key1);
//				if(first != and) {
//					System.out.println("False");
//					return;
//				}
//			}
//			//permutation ±¸ÇÏ±â
//		} 
//		else {
//			// 2 2 1 ÀÌ·± ½Ä 
//		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input string: ");
		String input = scan.nextLine();
		System.out.println("# Output #");
		palindrome(input);
	}
}
