public class HeapSort {
    static void heapify(int[] arr, int n, int i) {
        int largest = i;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        } 
    }
   public static void main(String[] args) {
    int[] arr = {1,5,4,2,3,6,9,8,7,0,11,25,36,95,47,85,12,36,58,94,52,36,78,45,12};
    System.out.println("Sorted Array: ");

    heapSort(arr);

    for(int i : arr) {
        System.out.print(i + " ");
    }
    System.out.println();
   } 
}

/* Heap Sort is a comparison-based, in-place sorting algorithm that uses a binary heap data structure. It first 
builds a max heap (for ascending order) so that the largest element is at the root, then repeatedly swaps the 
root with the last element, reduces the heap size, and heapifies to maintain the heap property.
Time Complexity: O(n log n) in best, average, and worst case.
Space Complexity: O(1) (in-place).
Stability: Not stable.

“Heap Sort is an in-place sorting algorithm that builds a binary heap and repeatedly extracts the maximum 
(or minimum) element to sort the array in O(n log n) time.”

A binary heap can be stored efficiently in an array without using pointers or tree nodes.
Index relationships:
Left child of node i → 2*i + 1
Right child of node i → 2*i + 2
Parent of node i → (i-1)/2
*/