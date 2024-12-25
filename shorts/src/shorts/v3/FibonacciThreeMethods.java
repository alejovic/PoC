package shorts.v3;

/**
 * Given a number n, write a function that returns the nth number in the Fibonacci sequence.
 * The Fibonacci sequence is a series of numbers in which each number is the sum of the two preceding ones.
 * The sequence starts with 0 and 1.
 * <p>
 * Implement the function using three different methods:
 * 1. Iterative
 * 2. Recursive
 * 3. Dynamic Programming
 * <p>
 * Iterative Method: Efficient and simple but uses a loop.
 * <p>
 * Recursive Method: Elegant but can be inefficient due to redundant calculations.
 * <p>
 * Dynamic Programming Method: Optimizes the recursive approach with memoization.
 */
public class FibonacciThreeMethods {

    public static void main(String[] args) {
        int n = 10; // Change this value to generate more terms
        System.out.println("\ntestFibonacciIterative");
        for (int i = 0; i < n; i++) {
            System.out.print(testFibonacciIterative(i) + " ");
        }
        System.out.println("\ntestFibonacciRecursive");
        for (int i = 0; i < n; i++) {
            System.out.print(testFibonacciRecursive(i) + " ");

        }
        System.out.println("\ntestFibonacciDP");
        testFibonacciDP(n);
    }

    /*******************************************************************************************************************
     * 1. Iterative Method
     * Time Complexity:
     * O(n): The iterative method has a linear time complexity since it calculates each Fibonacci number once.
     *
     * Space Complexity:
     * O(1): The space complexity is constant since it only uses a constant amount of space for the variables.
     ******************************************************************************************************************/
    public static int testFibonacciIterative(int n) {
        return fibonacciIterative(n);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int prev1 = 0, prev2 = 1;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    /*******************************************************************************************************************
     * 2. Recursive Method
     * Time Complexity:
     * O(2^n): This is because the recursive method results in an exponential number of calls.
     * Each call to fib(n) makes two calls to fib(n-1) and fib(n-2), leading to a tree of calls.
     *
     * Space Complexity:
     * O(n): The space complexity is determined by the depth of the recursion tree, which can go as deep as n.
     * Each recursive call adds a new layer to the call stack.
     ******************************************************************************************************************/

    public static int testFibonacciRecursive(int n) {
        return fibonacciRecursive(n);
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }


    /*******************************************************************************************************************
     * 3. Dynamic Programming Method (Memoization)
     * Time Complexity:
     * O(n): Each Fibonacci number from 0 to n is calculated only once and then stored in the memoization array.
     *
     * Space Complexity:
     * O(n): The space complexity is linear due to the memoization array used to store the Fibonacci numbers up to n.
     ******************************************************************************************************************/


    public static int testFibonacciDP(int n) {
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciDP(i, memo) + " ");
        }
        return fibonacciDP(n, memo);
    }

    public static int fibonacciDP(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] == 0) {
            memo[n] = fibonacciDP(n - 1, memo) + fibonacciDP(n - 2, memo);
        }
        return memo[n];
    }
}

