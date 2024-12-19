package shorts.v1;

public class VowelCountInSubstrings {


    public static void main(String[] args) {
        String input = "aei";
        System.out.println("Total number of vowels in all substrings: " + countVowelsInAllSubstrings(input));
    }

    public static int countVowelsInAllSubstrings(String s) {
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(s.charAt(i))) {
                int contribution = (i + 1) * (n - i);
                count += contribution;
                System.out.println("Character: " + s.charAt(i) + ", Position: " + i + ", Substrings: " + contribution);
            }
        }
        return count;
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
