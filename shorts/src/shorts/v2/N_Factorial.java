package shorts.v2;

/**
 * 12. How can you find the factorial of an integer in Java?
 * F(n) = F(1)*F(2)...F(n-1)*F(n)
 */
public class N_Factorial {

    public static void main(String[] args) {
        System.out.println("Factorial 5: " + factorial(5));
    }

    public static long factorial(long n) {
        if (n == 1)
            return 1;
        else
            return (n * factorial(n - 1));
    }
}
