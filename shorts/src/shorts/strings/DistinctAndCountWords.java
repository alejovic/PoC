package shorts.strings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * This class demonstrates how to count distinct words in a sentence.
 * <p>
 * To find and count the distinct words in a sentence, you can use a combination of a HashSet to store the
 * distinct words and a HashMap to count the occurrences of each word.
 */
public class DistinctAndCountWords {

    public static void main(String[] args) {
        String sentence = "This is a test. This test is simple.";
        Map<String, Long> wordCount = countDistinctWordsWithLambda(sentence);

        System.out.println("Distinct words and their counts:");
        wordCount.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    public static Map<String, Long> countDistinctWords(String sentence) {
        String[] words = sentence.toLowerCase().split("\\W+");
        Set<String> distinctWords = new HashSet<>();
        Map<String, Long> wordCount = new HashMap<>();

        for (String word : words) {
            distinctWords.add(word);
            wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1L);
        }

        return wordCount;
    }

    public static Map<String, Long> countDistinctWordsWithLambda(String sentence) {
        return Arrays.stream(sentence.toLowerCase().split("\\W+"))//regular expression that matches non-word characters
                // Use Collectors.groupingBy() to group words by their value
                // and Collectors.counting() to count occurrences of each word.
                // The result is stored in a HashMap.
                .collect(Collectors.groupingBy(word -> word, HashMap::new, Collectors.counting()));
    }
}
