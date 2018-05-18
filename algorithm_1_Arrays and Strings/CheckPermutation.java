import java.util.Enumeration;
import java.util.Hashtable;

public class CheckPermutation {
   public static boolean permutation(String str1, String str2) {
      if (str1.length() != str2.length()) {
         return false;
      } else {
         int i;
         Hashtable<String, Integer> h = new Hashtable<String, Integer>();
         for (i = 0; i < str1.length(); i++) {
            h.put(str1.substring(i, i + 1), 1);
         }
         for (i = 0; i < str2.length(); i++) {
            if (h.containsKey(str2.substring(i, i + 1))) {
               int tmp = h.get(str2.substring(i, i + 1));
               h.put(str2.substring(i, i + 1), ++tmp);
            }
            else
               h.put(str2.substring(i, i + 1), 1);
         }
         Enumeration keys1 = h.keys();
         while (keys1.hasMoreElements()) {
            String key = (String) keys1.nextElement();
            System.out.println("Key: " + key + " value: " + h.get(key));
         }
         Enumeration keys2 = h.keys();
         while (keys2.hasMoreElements()) {
            String key = (String) keys2.nextElement();
            if(h.get(key) % 2 != 0) {
            		return false;
            }
         }
         return true;
      }
   }

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      if(permutation("dabe", "eba"))
         System.out.println("Permutation");
      else
         System.out.println("Not permutation");
   }
}