package shorts.arrays;

/**
 * How do you find the maximum subarray sum in an array in Java?
 * o find the subarray with the maximum sum and return its sum, you can use Kadane's Algorithm.
 * This algorithm is efficient and runs in O(n) time complexity.
 */
public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3}; // Example array
        System.out.println("The maximum subarray sum is: " + maxSubarraySum(arr));
    }

    public static int maxSubarraySum(int[] arr) {
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
