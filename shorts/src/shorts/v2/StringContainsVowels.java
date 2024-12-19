package shorts.v2;

public class StringContainsVowels {

    public static void main(String[] args) {
        String string = "Hello World!";
        System.out.println("containsVowels: " + containsVowels(string));
    }

    public static boolean containsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
