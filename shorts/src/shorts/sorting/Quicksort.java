package shorts.sorting;

/**
 * shorts.v1.Quicksort algorithm implementation in Java.
 */
public class Quicksort {

    public static void main(String[] args) {
        int[] array = {12, 4, 5, 6, 7, 3, 1, 15};
        quicksort(array, 0, array.length - 1);
        System.out.println("Sorted array: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void quicksort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
