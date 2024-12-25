package shorts.strings;

/**
 * Given a string str, the task is to find the longest substring which is a palindrome.
 * If there are multiple answers, then return the first appearing substring.
 * <p>
 * Input: str = “forgeeksskeegfor”
 * Output: “geeksskeeg”
 * Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc.
 * But the substring “geeksskeeg” is the longest among all.
 * <p>
 * Input: str = “Geeks”
 * Output: “ee”
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "Geeks"; // Example string
        System.out.println("The longest palindromic substring is: " + longestPalindromicSubstring(str));
    }

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);   // Odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
