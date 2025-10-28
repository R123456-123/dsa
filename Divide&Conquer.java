class DivideAQ {
    static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minInx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minInx]) {
                    minInx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minInx];
            arr[minInx] = temp;
        }
    }

    static void priArr(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] arr = { 64, 25, 12, 22, 11 };

        selectionSort(arr);

        priArr(arr);

    }
}

class QuickSort {
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
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

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);

        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 7, 6, 5, 4, 3, 2, 1};

        quicksort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}