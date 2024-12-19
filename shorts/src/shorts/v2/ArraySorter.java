package shorts.v2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 10. How do you sort an array in Java?
 */
public class ArraySorter {

    public static void main(String[] args) {
        method1();
        method2();
    }

    public static void method1() {
        int[] array = {1, 2, 3, -1, -2, 4};
        Arrays.sort(array);
        System.out.println("Sorted array in ascending order: " + Arrays.toString(array));

    }


    public static void method2() {
        Integer[] array = {5, 3, 8, 1, 2};
        // Sort the array in ascending order
        Arrays.sort(array, (a, b) -> a - b);
        System.out.println("Sorted array in ascending order: " + Arrays.toString(array));

        Arrays.sort(array, Comparator.comparingInt(a -> a));
        System.out.println("Sorted array in ascending order: " + Arrays.toString(array));
        // Sort the array in descending order
        Arrays.sort(array, (a, b) -> b - a);
        System.out.println("Sorted array in descending order: " + Arrays.toString(array));

        Arrays.sort(array, Comparator.comparingInt(a -> -a));
        System.out.println("Sorted array in descending order: " + Arrays.toString(array));
    }
}
