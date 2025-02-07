package shorts.v4;

import java.util.Stack;

public class BasicCalculator {

    public int calculateBasic(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            // . .
            // what if () --> calculateAdvanced
            // . .
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public int calculateAdvanced(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        char operation = '+';
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            } else if (currentChar == '(') {
                int j = i, braces = 0;
                for (; i < s.length(); i++) {
                    if (s.charAt(i) == '(') braces++;
                    if (s.charAt(i) == ')') braces--;
                    if (braces == 0) break;
                }
                currentNumber = calculateAdvanced(s.substring(j + 1, i));
            }
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = currentChar;
                currentNumber = 0;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        String expression = "1 + 1";
        System.out.println("Result: " + calculator.calculateAdvanced(expression)); // Output: 2

        expression = "2-1 + 2";
        System.out.println("Result: " + calculator.calculateAdvanced(expression));

        expression = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Result: " + calculator.calculateAdvanced(expression));

        // --
        String expression1 = "3+2*2";
        System.out.println("Result: " + calculator.calculateBasic(expression1)); // Output: 7

        String expression2 = " 3/2 ";
        System.out.println("Result: " + calculator.calculateBasic(expression2)); // Output: 1

        String expression3 = " 3+5 / 2 ";
        System.out.println("Result: " + calculator.calculateBasic(expression3)); // Output: 5
    }
}
