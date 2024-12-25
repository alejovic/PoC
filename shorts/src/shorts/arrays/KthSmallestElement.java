package shorts.arrays;

import java.util.Random;

/**
 * Given an array arr[] of N distinct elements and a number K, where K is smaller than the size of the array.
 * Find the K’th smallest element in the given array.
 *
 * To find the K'th smallest element in an array of distinct elements, you can use the Quickselect algorithm,
 * which is an efficient way to solve this problem with an average time complexity of O(n).
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15}; // Example array
        int k = 3; // K'th smallest element to find
        System.out.println("The " + k + "rd smallest element is: " + kthSmallest(arr, k));
    }

    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1); // k - 1 because array is 0-indexed
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        pivotIndex = partition(arr, left, right, pivotIndex);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i <= right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }

        swap(arr, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

