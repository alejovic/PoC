package shorts.v3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenNDimensionalArrayFlatMap {

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
        List<Integer> flattenedList = flattenHelper(array)
                .collect(Collectors.toList());
        return flattenedList.stream().mapToInt(i -> i).toArray();
    }

    private static Stream<Integer> flattenHelper(Object[] array) {
        return Arrays.stream(array).flatMap(element -> {
            if (element instanceof Object[]) {
                return flattenHelper((Object[]) element);
            } else {
                return Stream.of((Integer) element);
            }
        });
    }
}
