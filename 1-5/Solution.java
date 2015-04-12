import java.util.HashMap;

public class Solution {
  public static void main(String args[]) {
    final long startTime = System.nanoTime();

    /*
    String testString1 = "apples   ";
    String testString2 = "   apples      ";
    String testString3 = "ba na na s         ";
    String testString4 = "   ";
    System.out.println("---Begin test---");

    System.out.println("For \"" + testString1 + "\": ");
    System.out.println(replaceSpaces(testString1.toCharArray(), 7));

    System.out.println("For \"" + testString2 + "\": ");
    System.out.println(replaceSpaces(testString2.toCharArray(), 9));

    System.out.println("For \"" + testString3 + "\": ");
    System.out.println(replaceSpaces(testString3.toCharArray(), 11));

    System.out.println("For \"" + testString4 + "\": ");
    System.out.println(replaceSpaces(testString4.toCharArray(), 1));
    */

    /* Print total time spent */
    final long duration = System.nanoTime() - startTime;
    System.out.println("\nduration: " + duration/1000000000.0 + "s");
  }

  public static String compressString(String str) {
    if(str==null) { return null; }
    if(str.length() < 3) { return str; }
    int sameCount = 0;
    String newStr = "";
    char currentChar = '\0';

    for(int i=0; i<str.length(); i++) {
      if (str.charAt(i) == currentChar) {
        sameCount++;
      }
      else {
        newStr += (currentChar + "" + sameCount);
        currentChar = str.charAt(i);
        sameCount = 1;
      }
      if (newStr.length() >= str.length()) {
        return str;
      }
    }
    return newStr;
  }

  public static void printCharArray(char[] arr) {
    System.out.print("[");
    for(char c : arr) {
      System.out.print(c + " ");
    }
    System.out.print("]\n");
  }

}
