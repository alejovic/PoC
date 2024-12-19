package shorts.v2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 17. Write Java program that checks if two arrays contain the same elements.
 */
public class ArraySameElements {

    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 2, 1};
        Integer[] a2 = {1, 2, 3};
        Integer[] a3 = {1, 2, 3, 4};

        System.out.println(sameElements(a1, a2));
        System.out.println(sameElements(a1, a3));

       // System.out.println(arraysContainSameElements(a1, a3));
    }

    static boolean sameElements(Object[] array1, Object[] array2) {
        Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
        Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));

        // if size is different, means there will be a mismatch
        if (uniqueElements1.size() != uniqueElements2.size()) return false;

        for (Object obj : uniqueElements1) {
            // element not present in both?
            if (!uniqueElements2.contains(obj)) return false;
        }

        return true;
    }

    public static boolean arraysContainSameElements(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        // Convert arrays to lists and sort them
        List<Integer> list1 = Arrays.stream(array1).boxed().sorted().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(array2).boxed().sorted().collect(Collectors.toList());
        // Compare sorted lists
        return list1.equals(list2);
    }


}
