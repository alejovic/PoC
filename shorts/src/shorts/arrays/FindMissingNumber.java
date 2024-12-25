package shorts.arrays;

/**
 * Given an array of integers from 1 to n with one number missing, write a function that returns the missing number.
 * <p>
 * The array is not sorted and may contain duplicates.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6}; // Example array
        int n = 6; // The range is [1, 6]
        System.out.println("The missing number is: " + findMissingNumber(arr, n));
    }

    /**
     * This approach ensures that you efficiently find the missing number with a time complexity of
     * O(n) and a space complexity of O(1)
     */

    public static int findMissingNumber(int[] arr, int n) {
        // Calculate the sum of the first n natural numbers
        int totalSum = n * (n + 1) / 2;

        // Calculate the sum of elements in the array
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        // The missing number is the difference between totalSum and arraySum
        return totalSum - arraySum;
    }
}
