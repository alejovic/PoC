package shorts.v3;

/**
 * Given a multi-dimensional array, write a function flatten(array: List) -> List that flattens the array into a single list.
 * <p>
 * The input array can have multiple dimensions and the output list should contain all the elements in the same order
 * as they appear in the input array.
 */

import java.util.ArrayList;
import java.util.List;

public class FlattenNDimensionalArray {

    public static void main(String[] args) {
        Object[] nDimensionalArray = {
                1,
                new Object[]{2, 3},
                new Object[]{
                        new Object[]{4, 5}, 6}
                , 7
        };

        int[] flattenedArray = flattenArray(nDimensionalArray);

        // Print the flattened array
        for (int i : flattenedArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] flattenArray(Object[] array) {
        List<Integer> resultList = new ArrayList<>();
        flattenHelper(array, resultList);
        return resultList.stream().mapToInt(i -> i).toArray();
    }

    private static void flattenHelper(Object[] array, List<Integer> resultList) {
        for (Object element : array) {
            if (element instanceof Object[]) {
                // Recursively flatten the nested array
                flattenHelper((Object[]) element, resultList);
            } else {
                resultList.add((Integer) element);
            }
        }
    }
}

