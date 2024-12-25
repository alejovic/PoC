package shorts.arrays;

/**
 * Given an integer array, the task is to find the maximum product of any subarray.
 * Input: arr[] = {-2, 6, -3, -10, 0, 2}
 * Output: 180
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums = {-2, 6, -3, -10, 0, 2}; // Example array
        System.out.println("The maximum product of any subarray is: " + maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currentMax;
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(temp * nums[i], currentMin * nums[i]));

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return maxProduct;
    }


}
