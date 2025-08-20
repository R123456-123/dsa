import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class Hashing {
    static List<Integer> intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> hs = new HashSet<>();

        for (int a : arr1) {
            hs.add(a);
        }

        List<Integer> res = new ArrayList<>();

        for (int i : arr2) {
            if (hs.contains(i)) {
                res.add(i);
                hs.remove(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 2, 1 };
        int[] arr2 = { 3, 2, 2, 3, 3, 2 };

        List<Integer> res = intersection(arr1, arr2);

        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}

// import java.util.HashSet;

// class Main {

//     static boolean findSubset(int[] arr1, int[] arr2) {
//         HashSet<Integer> hs = new HashSet<>();

//         for(int a : arr1) {
//             hs.add(a);
//         }

//         for(int i : arr2) {
//             if(!hs.contains(i)) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     public static void main(String[] args) {
//         int[] a = {11, 1, 13, 21, 3, 7};
//         int[] b = {11, 3, 7, 1};

//         if (findSubset(a, b)) {
//             System.out.println("true");
//         } else {
//             System.out.println("false");
//         }
//     }
// }