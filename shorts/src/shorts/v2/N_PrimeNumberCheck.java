package shorts.v2;

public class N_PrimeNumberCheck {

    public static void main(String[] args) {
        System.out.println("0: " + isPrime(0));
        System.out.println("1: " + isPrime(1));
        System.out.println("2: " + isPrime(2));
        System.out.println("8: " + isPrime(8));

        System.out.println("19: " + isPrime(19));
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % 2 == 0) {
                return false;
            }
        }

        if (n == 2) return true;
        if (n == 0 || n == 1) return false;
        return true;
    }
}
