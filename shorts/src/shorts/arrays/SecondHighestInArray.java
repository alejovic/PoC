package shorts.arrays;

/**
 * 19. How do you find the second largest number in an array in Java?
 */
public class SecondHighestInArray {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(findSecondHighest(array));
    }

    private static int findSecondHighest(int[] array) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }
}
