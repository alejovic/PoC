package shorts.strings;

/**
 * This class demonstrates how to check if a string contains vowels.
 */
public class StringContainsVowels {

    public static void main(String[] args) {
        String string = "Hello World!";
        System.out.println("containsVowels: " + containsVowels(string));
    }

    public static boolean containsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
