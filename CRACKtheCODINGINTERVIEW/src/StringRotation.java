///* CRACKING the CODING INTERVIEW
//1. Arrays and Strings
//1-9) String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat"). */
//
//import java.util.Scanner;
//
//public class StringRotation {
//	public static boolean stringRotation(String str1, String str2) {
//		int len = str1.length();
//		if(len > 0 && len != str2.length()) {
//			String s1s1 = str1 + str1;
//			return isSubString(s1s1,str2); //checks if one word is a substring of another: isSubString(s1,s2)
//		}
//		else
//			return false;
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Input string1: ");
//		String str1 = scan.nextLine();
//		System.out.println("Input string2: ");
//		String str2 = scan.nextLine();
//		stringRotation(str1, str2);
//		System.out.println(str1 + str2);
//	}
//}
