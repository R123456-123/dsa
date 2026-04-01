package searching;
// binarySearch(arr, target) may use after arr.sort()

// binarySearch(arr, startIndex, endIndex(ex), target)
// Collections.binarySearch() java.util.Collections.binarySearch() method is a java.util.Collections class method 
// that returns the position of an object in a sorted list.
// Arrays.binarysearch() vs Collections.binarySearch() 
// Arrays.binarysearch() works for arrays which can be of primitive data type also. Collections.binarysearch() 
// works for objects Collections like ArrayList and LinkedList. 
// Important Points: 

// If input list is not sorted, the results are undefined.
// If there are duplicates, there is no guarantee which one will be found.
// This method runs in log(n) time for a "random access" list like ArrayList.
// If the specified list does not implement the RandomAccess interface and is large, this method will do an
// iterator-based binary search that performs O(n) link traversals and O(log n) element comparisons.

// The Binary Search Algorithm can be implemented in the following two ways
// Iterative Binary Search Algorithm && Recursive Binary Search Algorithm

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class BinarySearch {
    // binary search iterative

    static int binarySearch1(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        Arrays.sort(arr);

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // recursive
    static int binarySearch2(int[] arr, int low, int high, int target) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                return binarySearch2(arr, mid + 1, high, target);
            } else {
                return binarySearch2(arr, low, mid - 1, target);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 8, 5, 9, 6, 1, 7, 2 };
        int left = 0, right = arr.length - 1;
        Arrays.sort(arr);
        int res1 = binarySearch1(arr, 9);
        int res2 = binarySearch2(arr, left, right, 9);

        if (res1 == -1) {
            System.out.println("The target is not present in array.");
        } else {
            System.out.println("The target is present at index " + res1 + ".");
        }

        if (res2 == -1) {
            System.out.println("The target is not present in array.");
        } else {
            System.out.println("The target is present at index " + res2 + ".");
        }
    }
}

// Time Complexity:
// -> Best Case: O(1)
// -> Average Case: O(log N)
// -> Worst Case: O(log N)
// Auxiliary Space: O(1), If the recursive call stack is considered then the
// auxiliary space will be O(log N).



class BinarySearch2 {
    static int binarySearch2(List<Integer> arr, int target, int left, int right) {

        if(right >= left) {
            int mid = left + (right - left) / 2;

            if(arr.get(mid) == target) {
               return mid;
            } 
            
            if(arr.get(mid) > target) {
               return binarySearch2(arr, target, left, mid - 1);
            } else {
               return binarySearch2(arr, target, mid + 1, right);
            } 
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,8,6,1,2,3,7,9};

        List<Integer> arr2 = new ArrayList<>();
        for(int i : arr) {
            arr2.add(i);
        }
        Collections.sort(arr2);
      
        int res2 = binarySearch2(arr2, 51, 0, arr2.size() - 1);

        if(res2 != -1) {
            System.out.println("Target idx: " + res2);
        } else {
             System.out.println("Target not found");
        }
    }
}