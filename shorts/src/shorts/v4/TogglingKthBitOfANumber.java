package shorts.v4;

/**
 * For a given number n, if k-th bit is 0, then toggle it to 1 and if it is 1 then, toggle it to 0.
 *
 * Input : n = 6, k = 1
 * Output : 7
 * 6 is represented as 110 in binary and has its first bit 0, so toggling  it will result in 111 i.e. 7.
 *
 * Input : n = 2, k = 3
 * Output : 6
 * 2 is represented as 010 in binary and has its 3rd bit 0, so toggling  it will result in 110 i.e. 6.
 *
 * Input : n = 75, k = 4
 * Output : 67
 * 75 is represented as 1001011 in binary and has its 4th bit 1, so toggling  it will result in 1000011 i.e. 67.
 */
public class TogglingKthBitOfANumber {
    static int toggleKthBit(int n, int k)
    {
        return (n ^ (1 << (k-1)));
    }

    // main function
    public static void main (String[] args)
    {
        int n = 5, k = 1;
        System.out.println(toggleKthBit(n , k));
    }
}
