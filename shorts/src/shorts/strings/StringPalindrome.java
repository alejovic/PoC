package shorts.strings;

/**
 * 7. How do you check whether a string is a palindrome in Java?
 */
public class StringPalindrome {

    public static void main(String[] args) {

    }

    public static boolean checkPalindromeString(String input) {
        boolean result = true;
        int length = input.length();

        for (int i = 0; i < length/2; i++) {
            if (input.charAt(i) != input.charAt(length - i - 1)) {
                result = false;
                break;
            }
        }

        return result;
    }
}
