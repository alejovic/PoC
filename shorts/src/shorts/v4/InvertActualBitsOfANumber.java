package shorts.v4;

/**
 * Given a non-negative integer n. The problem is to invert the bits of n and print the number obtained after
 * inverting the bits. Note that
 * the actual binary representation of the number is being considered for inverting the bits,
 * no leading 0’s are being considered.
 */
public class InvertActualBitsOfANumber {

    // Method 1 (Using bitwise operators)
    static void invertBits(int num) {
        // calculating number of
        // bits in the number
        int x = (int) (Math.log(num) /
                Math.log(2)) + 1;

        // Inverting the
        // bits one by one
        for (int i = 0; i < x; i++)
            num = (num ^ (1 << i));

        System.out.println(num);
    }

    // Method 2 (Using bit-wise operators)
    static void opposite(int n) {
        int x = 1;
        while (x <= n) {
            x <<= 1;
        }
        x--;
        System.out.println(x ^ n);
    }

    // Driver code
    public static void main(String[] args) {
        int num = 11;
        invertBits(num);
        opposite(num);
    }

}
