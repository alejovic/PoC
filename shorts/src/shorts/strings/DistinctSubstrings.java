package shorts.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given a string, count all distinct substrings of the given string.
 * To count all distinct substrings of a given string, you can use a trie (prefix tree) data structure
 * to efficiently store and count the substrings.
 * <p>
 * Input : abcd
 * Output : abcd abc ab a bcd bc b cd c d
 * All Elements are Distinct
 */

public class DistinctSubstrings {

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "aaa";

        System.out.println("Number of distinct substrings in \"" + str1 + "\": " + countDistinctSubstrings(str1));
        System.out.println("Number of distinct substrings in \"" + str2 + "\": " + countDistinctSubstrings(str2));
    }

    public static int countDistinctSubstrings(String str) {
        Set<String> substrings = new HashSet<>();
        int n = str.length();

        // Generate all substrings and add them to the set
        for (int i = 0; i < n; i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < n; j++) {
                currentSubstring.append(str.charAt(j));
                substrings.add(currentSubstring.toString());
            }
        }

        // Print all distinct substrings (for demonstration)
        substrings.forEach(x -> System.out.print(x + " "));

        return substrings.size();
    }

    public static int countDistinctSubstringsWithLambda(String str) {
        Set<String> substrings = new HashSet<>();
        str.chars().forEach(i -> substrings.addAll(str.substring(i).chars()
                .mapToObj(j -> str.substring(i, j + 1))
                .collect(Collectors.toSet())));
        // Print all distinct substrings (for demonstration)
        substrings.forEach(System.out::println);
        return substrings.size();
    }
}
