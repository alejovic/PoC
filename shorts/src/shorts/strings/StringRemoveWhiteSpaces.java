package shorts.strings;

/**
 * 8. How do you remove spaces from a string in Java?
 */
public class StringRemoveWhiteSpaces {

    public static void main(String[] args) {

    }

    public static String removeWhiteSpaces(String input) {
        StringBuilder output = new StringBuilder();

        char[] charArray = input.toCharArray();

        for (char c : charArray) {
            if (!Character.isWhitespace(c))
                output.append(c);
        }

        return output.toString();
    }
}
