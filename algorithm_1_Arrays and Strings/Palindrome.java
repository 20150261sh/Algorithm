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
//			//permutation 구하기
//		} 
//		else {
//			// 2 2 1 이런 식 
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
