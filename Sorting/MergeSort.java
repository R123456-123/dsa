// “Merge Sort is a stable, divide-and-conquer sorting algorithm with O(n log n) time complexity that works by recursively dividing the array and 
// merging sorted halves.”
/* Merge Sort is a divide and conquer sorting algorithm that:
> divide: Divides the array into two halves recursively until each subarray has one element.
> conquer: Conquers by merging the smaller sorted subarrays into larger sorted subarrays.
> merge: Finally produces a fully sorted array.*/

public class MergeSort {
    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++) {                              //an stable sort but not in-place sort
            L[i] = arr[l + i];
        }

        for(int i = 0; i < n2; i++) {
            R[i] = arr[m + i + 1];
        }

        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + (r - l)/ 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6,7,8,9,1,2,3,4,5,45,5,68,24,95,24,65,35,17,85,12,1,42,563,56,32,6,2,5};
        int n = arr.length;

        System.out.println("Sorted Array: ");

        mergeSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}

/*
-> Recurrence Relation of Merge Sort
The recurrence relation of merge sort is:

       { Θ(1) if n = 1 }
T(n) =       
       { 2T(n/2) + Θ(n) if n > 1 }
 

T(n) Represents the total time time taken by the algorithm to sort an array of size n.
2T(n/2) represents time taken by the algorithm to recursively sort the two halves of the array. Since each half has n/2 elements, we have two recursive calls with input size as (n/2).
O(n) represents the time taken to merge the two sorted halves

-> Complexity Analysis of Merge Sort

> Time Complexity:
Best Case: O(n log n), When the array is already sorted or nearly sorted.
Average Case: O(n log n), When the array is randomly ordered.
Worst Case: O(n log n), When the array is sorted in reverse order.
> Auxiliary Space: O(n), Additional space is required for the temporary array used during merging.

-> Applications of Merge Sort:

Sorting large datasets
• External sorting (when the dataset is too large to fit in memory)
• Inversion counting
• Merge Sort and its variations are used in library methods of programming languages.
    • Its variation TimSort is used in Python, Java Android and Swift. The main reason why it is preferred to sort non-primitive types is stability which is not there in QuickSort.
    • Arrays.sort in Java uses QuickSort while Collections.sort uses MergeSort.
• It is a preferred algorithm for sorting Linked lists.
• It can be easily parallelized as we can independently sort subarrays and then merge.
• The merge function of merge sort to efficiently solve the problems like union and intersection of two sorted arrays.

-> Advantages

Stability : Merge sort is a stable sorting algorithm, which means it maintains the relative order of equal elements in the input array.
Guaranteed worst-case performance: Merge sort has a worst-case time complexity of O(N logN) , which means it performs well even on large datasets.
Simple to implement: The divide-and-conquer approach is straightforward.
Naturally Parallel : We independently merge subarrays that makes it suitable for parallel processing.

-> Disadvantages

Space complexity: Merge sort requires additional memory to store the merged sub-arrays during the sorting process.
Not in-place: Merge sort is not an in-place sorting algorithm, which means it requires additional memory to store the sorted data. This can be a disadvantage in applications where memory usage is a concern.
Merge Sort is Slower than QuickSort in general as QuickSort is more cache friendly because it works in-place.*/



