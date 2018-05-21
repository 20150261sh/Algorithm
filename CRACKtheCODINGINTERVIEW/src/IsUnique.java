/* CRACKING the CODING INTERVIEW
1. Arrays and Strings
1-1) Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures? */

import java.util.Hashtable;

public class IsUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> h = new Hashtable<String, Integer>();
		String str = "aple";
		for (int i = 0; i < str.length(); i++) {
			if (h.containsKey(str.substring(i, i + 1))) {
				System.out.println("String has same characters");
				return;
			} 
			else {
				h.put(str.substring(i, i + 1), 1);
			}
		}
		System.out.println("String has all unique characters.");
	}
}
