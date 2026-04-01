import java.util.*;

public class ScannerPractice {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      // for array input
      int n = sc.nextInt();

      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = sc.nextInt();
      }

      // for 2d array input

      int m = sc.nextInt();
      int y = sc.nextInt();

      int[][] arr2d = new int[m][y];

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < y; j++) {
            arr2d[i][j] = sc.nextInt();
         }
      }

      // for single variable input

      int a = sc.nextInt();

      // for string input

      String str = sc.next();

      // for single character input

      char c = sc.next().charAt(0);

      // for string of words input
      String str2 = sc.nextLine();

      sc.nextLine(); // use this to consume the newline character left by nextInt() or next() before
                     // using nextLine()

      while (sc.hasNextLine()) {
         String line = sc.nextLine();
         System.out.println(line);
      }

      // for boolean input

      boolean bool = sc.nextBoolean();

      // for double input

      double d = sc.nextDouble();

      // for

      sc.close();
   }
}
