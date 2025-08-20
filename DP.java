//fabbonacci

//tabulation
// public class DP {
//    public static int fibo(int n ) {
//     if(n == 0) return 0;
//     if(n == 1) return 1;

//     int[] F = new int[n + 1];

//     F[0] = 0;
//     F[1] = 1;

//     for(int i = 2; i <= n; i++) {
//        F[i] = F[i - 1] + F[i - 2];
//     }

//     return F[n];
//    } 

//    public static void main(String[] args) {
//     System.out.println(fibo(5));
//    }
// }

//memoization
import java.util.Arrays;
public class DP {
    public static int fibRec(int n, int[] memo) {
       if(n <= 1) {
        return n;
       }

       if(memo[n] != -1) {
         return memo[n];
       }

       memo[n] = fibRec(n - 1, memo) + fibRec(n - 2, memo);

       return memo[n];
    }

    public static int fibo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibRec(n, memo);
    }

    
   public static void main(String[] args) {
    System.out.println(fibo(5));
   }
}