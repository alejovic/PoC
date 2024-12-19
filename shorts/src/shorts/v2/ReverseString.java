package shorts.v2;

public class ReverseString {

    public static void main(String[] args) {
        String reverseThis = "Hello, World!";
        System.out.println("Reversed string: " + reverseString(reverseThis));
    }

    private static String reverseString(String reverseThis) {
        StringBuilder output = new StringBuilder(reverseThis.length());
        char[] charArray = reverseThis.toCharArray();
        for (int index = charArray.length - 1; index >= 0; index--) {
            output.append(charArray[index]);
        }
        return output.toString();
    }

}
