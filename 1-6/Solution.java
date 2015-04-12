import java.util.HashMap;

public class Solution {
  public static void main(String args[]) {
    final long startTime = System.nanoTime();

    String testString1 = "aabcccccaaa";
    String testString2 = "";
    char[] testArray1 = { 'a', 'b', 'c' };
    char[] testArray2 = { 'd', 'e', 'f' };
    char[] testArray3 = { 'g', 'h', 'i' };
    char[][] testMatrix1 = { testArray1, testArray2, testArray3 };
/*
    //System.out.println("For \"" + testString1 + "\": ");
    System.out.println(compressString(testString1));

    //System.out.println("For \"" + testString2 + "\": ");
    System.out.println(compressString(testString2));

    //System.out.println("For \"" + testString3 + "\": ");
    System.out.println(compressString(testString3));

    //System.out.println("For \"" + testString4 + "\": ");
    System.out.println(compressString(testString4));

    /* Print total time spent */
    final long duration = System.nanoTime() - startTime;
    System.out.println("\nduration: " + duration/1000000000.0 + "s");
  }

  public static char[][] rotateMatrix(char[][] matrix) {
    if (matrix == null) { return null; }
    if (matrix.length == 0 || matrix[0].length == 0 || matrix.length == matrix[0].length) {
      return matrix;
    }
    char temp = '\0';
    int offY = 0;
    int offX = 0;
    for (int i=0; i<matrix.length/2; i++) {
      for (int j=0; j<matrix.length; i++) {
        temp = matrix[i][j];
        offY = Math.abs(matrix.length-j);
        offX = Math.abs(matrix.length-i);
        matrix[i][j] = matrix[offY][i];
        matrix[j][offX] = temp;
      }
    }
    return matrix;
  }

  public static void printCharArray(char[] arr) {
    System.out.print("[");
    for(char c : arr) {
      System.out.print(c + " ");
    }
    System.out.print("]\n");
  }
}