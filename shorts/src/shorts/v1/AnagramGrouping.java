package shorts.v1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramGrouping {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        solution1(args);
    }

    public static void solution1(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "art", "evil", "vile", "veil");

//        SELECT sorted_word, GROUP_CONCAT(word) AS anagram_group
//        FROM (
//                SELECT word, CHARACTER_SORT(word) AS sorted_word
//                FROM words
//        ) subquery
//        GROUP BY sorted_word
//        HAVING COUNT(*) > 1;

        Function<String, String> distinct = (word) -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        };
//        words.stream().forEach(word -> System.out.println(distinct.apply(word)));

        // Grouping anagrams
        Map<String, List<String>> groupedAnagrams = words.stream()
                .collect(Collectors.groupingBy(distinct));

        groupedAnagrams.forEach((key, value) -> System.out.println(key + " -> " + value));

        // Converting to List of Groups
        List<List<String>> result = new ArrayList<>(groupedAnagrams.values());

        // Printing the result
        result.forEach(System.out::println);
    }

    public static void solution2(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "art", "evil", "vile", "veil");

        // Grouping anagrams directly into a List of Lists
        List<List<String>> groupedAnagrams = words.stream()
                .collect(Collectors.toMap(
                        AnagramGrouping::sortedString, // Key is the sorted string
                        Collections::singletonList,             // Initial value for a new key
                        (existing, newList) -> {                // Merge function for duplicate keys
                            List<String> merged = new ArrayList<>(existing);
                            merged.addAll(newList);
                            return merged;
                        }
                ))
                .values()
                .stream()
                .collect(Collectors.toList());

        // Printing the result
        groupedAnagrams.forEach(System.out::println);
    }

    /**
     * Utility function to sort the characters of a string
     * This will serve as a key for grouping anagrams
     */
    private static String sortedString(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
