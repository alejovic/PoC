package shorts.v1;

public class ReversePalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println("Reversed palindromic substrings: " + isPalindrome(s));
        System.out.println("Reversed palindromic substrings: " + reversePalindromicSubstrings(s));
    }

    public static String reversePalindromicSubstrings(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int start = i;
            while (i < s.length() && isPalindrome(s, start, i)) {
                i++;
            }
            if (i > start + 1) {
                result.append(new StringBuilder(s.substring(start, i)).reverse());
            } else {
                result.append(s.charAt(start));
                i++;
            }
        }
        return result.toString();
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
       return isPalindrome(s, left, right);
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;

    }
}
