package shorts.v2;

import java.util.List;

/**
 *
 */
public class N_OddNumberCheck {

    public static void main(String[] args) {

    }

    public static boolean method1(List<Integer> list) {
        for (int i : list) {
            if (i % 2 == 0)
                return false;
        }

        return true;
    }

    public static boolean method2(List<Integer> list) {
        return list
                .parallelStream() // parallel stream for faster processing
                .anyMatch(x -> x % 2 != 0); // return as soon as any elements match the condition
    }
}
