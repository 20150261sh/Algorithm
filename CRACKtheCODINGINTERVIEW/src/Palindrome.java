import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Palindrome {

	public static boolean palindrome(String input) {
		Hashtable<String, Integer> h = new Hashtable<String, Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (h.containsKey(input.substring(i, i + 1))) {
				int tmp = h.get(input.substring(i, i + 1));
				h.put(input.substring(i, i + 1), ++tmp);
			} else {
				h.put(input.substring(i, i + 1), 1);
			}
		}
		int value, count = 0, odd = 0, even = 0;
		Enumeration keys2 = h.keys();
		String key2 = (String) keys2.nextElement();
		if (input.length() % 2 == 0) { // 길이가 짝수시 모든 문자 개수가 짝수 개
			Enumeration keys1 = h.keys();
			while (keys1.hasMoreElements()) {
				String key1 = (String) keys1.nextElement();
				value = h.get(key1);
				if(value % 2 != 0)
					return false;
			}
		} else { //길이가 홀수시 
			// 2 2 1 이런 식
			Enumeration keys3 = h.keys();
			while(keys3.hasMoreElements()) {
				String key3 = (String) keys3.nextElement();
				value = h.get(key3);
				if(value % 2 != 0)
					odd++;
				else 
					even++;
			}
			if(odd > 1)
				return false;
		}
		return true;
		//permutation 구하기?
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input string: ");
		String input = scan.nextLine();
		input = input.replaceAll(" ", "");
		System.out.println("# Output #");
		System.out.println(palindrome(input));
	}
}