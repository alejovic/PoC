package shorts.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPangramChecker {

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = isPangram(sentence);
        System.out.println("Is the sentence a pangram? " + isPangram);
    }

    public static boolean isPangram(String sentence) {
        Set<Character> alphabetSet = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            if (Character.isLetter(c)) {
                alphabetSet.add(Character.toLowerCase(c));
            }
        }
        return alphabetSet.size() == 26;
    }

    public static boolean isPangramWithRegex(String sentence) {
        String lowerCaseSentence = sentence.toLowerCase();
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher;
        for (char c = 'a'; c <= 'z'; c++) {
            matcher = pattern.matcher(lowerCaseSentence);
            if (!matcher.find()) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPangramWithStreams(String sentence) {
        return sentence.toLowerCase().chars().filter(Character::isLetter).distinct().count() == 26;
    }
}
