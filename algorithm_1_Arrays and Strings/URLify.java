import java.util.Scanner;

public class URLify {
	public static String Replace(String input) {
		String[] tmp = input.split(", ");
		String str = tmp[0];
		int length = Integer.parseInt(tmp[1]);
		str = str.replaceAll("\"", "");
		char[] a = str.toCharArray();
		char[] b = new char[length];
		for (int i = 0; i < length; i++) {
			b[i] = a[i];
		}
		str = new String(b);
		str = str.replaceAll(" ", "%20");
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Input string: ");
		String input = scan.nextLine();
		System.out.println("# Output #");
		System.out.println(Replace(input));
	}

}
