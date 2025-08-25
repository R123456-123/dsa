//“Quick Sort is an in-place, divide-and-conquer sorting algorithm that partitions the array around a pivot, recursively sorts subarrays, and 
// generally runs in O(n log n) but can degrade to O(n²) in the worst case.”
/* Quick Sort is a divide and conquer sorting algorithm that:
Picks a pivot element.
Partitions the array so that elements smaller than the pivot go to the left and larger elements go to the right.
Recursively applies the same process to the left and right subarrays. */

/*here are mainly three steps in the algorithm:

Choose a Pivot: Select an element from the array as the pivot. The choice of pivot can vary (e.g., first element, last element, random element, or median).
Partition the Array: Re arrange the array around the pivot. After partitioning, all elements smaller than the pivot will be on its left, and all elements greater than the pivot will be on its right. The pivot is then in its correct position, and we obtain the index of the pivot.
Recursively Call: Recursively apply the same process to the two partitioned sub-arrays (left and right of the pivot).
Base Case: The recursion stops when there is only one element left in the sub-array, as a single element is already sorted. */

/*Choice of Pivot
There are many different choices for picking pivots.

> Always pick the first (or last) element as a pivot. The below implementation picks the last element as pivot. The problem with this 
approach is it ends up in the worst case when array is already sorted.
> Pick a random element as a pivot. This is a preferred approach because it does not have a pattern for which the worst case happens.
> Pick the median element is pivot. This is an ideal approach in terms of time complexity as we can find median in linear time and the 
> function will always divide the input array into two halves. But it takes more time on average as median finding has high constants. */

/*The key process in Quick Sort is partitioning, which rearranges elements around a pivot. There are three common partition schemes, all with O(n) time complexity:
Naive Partition → Uses an extra array to first place smaller, then larger elements. Requires O(n) extra space.
Lomuto Partition → Simple method, keeps an index of smaller elements and swaps accordingly. Easy to implement.
Hoare’s Partition → Most efficient; scans from both ends and swaps misplaced elements. Performs fewer swaps than Lomuto. */

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for(int j = low; j <= high; j++) {                     //not an stable sort but in-place sort
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {45,54,78,12,45,36,25,14,78,96,32,15,14,1,2,5,3,6,9,8,7,4,0};
        int n = arr.length;

        System.out.println("Sorted arr");

        quickSort(arr, 0, n - 1);

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
-> Complexity Analysis of Quick Sort

> Time Complexity:
Best Case: (Ω(n log n)), Occurs when the pivot element divides the array into two equal halves.
Average Case (θ(n log n)), On average, the pivot divides the array into two parts, but not necessarily equal.
Worst Case: (O(n²)), Occurs when the smallest or largest element is always chosen as the pivot (e.g., sorted arrays).

> Auxiliary Space:
Worst-case scenario: O(n) due to unbalanced partitioning leading to a skewed recursion tree requiring a call stack of size O(n).
Best-case scenario: O(log n) as a result of balanced partitioning leading to a balanced recursion tree with a call stack of size O(log n).
Please refer Time and Space Complexity Analysis of Quick Sort for more details.

-> Advantages of Quick Sort
It is a divide-and-conquer algorithm that makes it easier to solve problems.
It is efficient on large data sets.
It has a low overhead, as it only requires a small amount of memory to function.
It is Cache Friendly as we work on the same array to sort and do not copy data to any auxiliary array.
Fastest general purpose algorithm for large data when stability is not required.
It is tail recursive and hence all the tail call optimization can be done.

-> Disadvantages of Quick Sort
It has a worst-case time complexity of O(n2), which occurs when the pivot is chosen poorly.
It is not a good choice for small data sets.
It is not a stable sort, meaning that if two elements have the same key, their relative order will not be preserved in the sorted output in case
of quick sort, because here we are swapping elements according to the pivot's position (without considering their original positions).

-> Applications of Quick Sort
Sorting large datasets efficiently in memory.
Used in library sort functions (like C++ std::sort and Java Arrays.sort for primitives).
Arranging records in databases for faster searching.
Preprocessing step in algorithms requiring sorted input (e.g., binary search, two-pointer techniques).
Finding the kth smallest/largest element using Quickselect (a variant of quicksort).
Sorting arrays of objects based on multiple keys (custom comparators).
Data compression algorithms (like Huffman coding preprocessing).
Graphics and computational geometry (e.g., convex hull algorithms).
*/