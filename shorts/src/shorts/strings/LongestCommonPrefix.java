package shorts.strings;

import java.util.Arrays;

/**
 * How do you find the longest common prefix in an array of strings in Java?
 * To find the longest common prefix among a list of strings, you can use a straightforward approach
 * that compares characters of each string.
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixStreams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return Arrays.stream(strs).reduce((s1, s2) -> {
            int minLength = Math.min(s1.length(), s2.length());
            for (int i = 0; i < minLength; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    return s1.substring(0, i);
                }
            }
            return s1.substring(0, minLength);
        }).orElse("");
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight", "float"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strs));
    }

}
