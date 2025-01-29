package shorts.v4;

/**
 * Given a string S, the task is to find minimum flips required to convert an initial binary
 * string consisting of only zeroes to S where every flip of a character flips all succeeding characters as well.
 *
 * Input: S = “01011”
 * Output: 3
 * Explanation:
 * Initial String – “00000”
 * Flip the 2nd bit – “01111”
 * Flip the 3rd bit – “01000”
 * Flip the 4th bit – “01011”
 * Total Flips = 3
 * Input: S = “01001”
 * Output: 3
 * Explanation:
 * Initial String – “00000”
 * Flip the 2nd bit – “01111”
 * Flip the 3rd bit – “01000”
 * Flip the 5th bit – “01001”
 * Total Flips = 3
 *
 */
public class MinimumFlips {
    // Function to return the count of
    // minimum flips required
    public static int minFlips(String target)
    {

        char curr = '1';
        int count = 0;
        for (int i = 0; i < target.length(); i++) {

            // If curr occurs in the final string
            if (target.charAt(i) == curr) {

                count++;

                // Switch curr to '0' if '1'
                // or vice-versa
                curr = (char)(48 + (curr + 1) % 2);
                System.out.println("curr: " + curr);
            }
        }

        return count;
    }

    // Driver Code
    public static void main(String args[])
    {

        String S = "01011";
        System.out.println(minFlips(S));
    }
}

