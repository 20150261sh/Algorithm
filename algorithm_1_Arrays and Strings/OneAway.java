
public class OneAway {

	public static boolean checkInsert(String str1, String str2) {
		if (str1.length() - str2.length() > 1 || str2.length() - str1.length() > 1)
			return false;
		int count = 0;
		String s1, s2;
		if (str1.length() > str2.length()) {
			s1 = str1;
			s2 = str2;
		} else {
			s1 = str2;
			s2 = str1;
		}
		char[] a1 = s1.toCharArray();
		char[] a2 = s2.toCharArray();
		int i = 0, j = 0;
		while (true) {
			if (j == a1.length)
				break;
			if (a2[i] == a1[j]) {
				i++;
				j++;
			} else {
				count++;
				j++;
			}
		}
		if (count > 1)
			return false;
		else
			return true;
	}

	public static boolean checkReplace(String str1, String str2) {
		int count = 0;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i])
				count++;
		}
		if (count > 1)
			return false;
		else
			return true;
	}

	public static void OneZeroAway(String str1, String str2) {
		System.out.print(str1 + ", " + str2 + " -> ");
		if (str1.length() == str2.length()) {
			System.out.println(checkReplace(str1, str2));
		} else {

			System.out.println(checkInsert(str1, str2));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneZeroAway("pales", "pale");
	}

}
