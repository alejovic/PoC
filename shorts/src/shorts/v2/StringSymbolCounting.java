package shorts.v2;

import java.util.Map;
import java.util.stream.Collectors;

public class StringSymbolCounting {
    public static void main(String[] args) {
        String input = "Hello, World!!!!";
        System.out.println("Symbol count: " + countSymbols(input));
    }

    private static String countSymbols(String input) {
        StringBuilder output = new StringBuilder();
        Map<String, Long> x = input.chars()
                .filter(x1 -> !Character.isLetter(x1))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        x.forEach((k, v) -> output.append("["+k + ":" + v+"]"));
        return output.toString();
    }
}
