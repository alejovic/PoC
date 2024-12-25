package shorts.arrays;

/**
 * Given an Array of size N and a value K, around which we need to right rotate the array.
 * How do you quickly print the right rotated array?
 * <p>
 * This approach has a time complexity of O(N).
 */

import java.util.Arrays;

public class RightRotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5}; // Example array
        int k = 3; // Number of positions to rotate
        rightRotate(arr, k);
        System.out.println("Right rotated array: " + Arrays.toString(arr));
    }

    public static void rightRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // In case k is greater than the length of the array

        // Reverse the whole array
        reverse(arr, 0, n - 1);

        // Reverse the first k elements
        reverse(arr, 0, k - 1);

        // Reverse the remaining elements
        reverse(arr, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
