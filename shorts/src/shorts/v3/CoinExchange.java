package shorts.v3;

/**
 * Given a monetary amount in dollars and a list of coin denominations,
 * write a function coin_exchange(amount: float, denominations: List[float]) -> List[Tuple[float, int]]
 * that returns a list of tuples representing the optimal change amount.
 * <p>
 * The denominations available for change can vary and are provided as input in the denominations list.
 * A change is considered optimal when it returns the least possible count of denominations.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CoinExchange {

    public static void main(String[] args) {
        double amount = 11.25; // example amount in dollars
        //List<Double> denominations = List.of(0.25, 0.1, 0.05, 0.01); // example denominations in dollars
        double[] denominationsArray = {0.25, 0.1, 0.05, 0.01}; // example denominations in dollars
        // Convert double array to List<Double>
        List<Double> denominations = Arrays.stream(denominationsArray).boxed().collect(Collectors.toList());
        //  List<Double> denominations =  Arrays.stream(denominationsArray).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        List<Tuple<Double, Integer>> change = coinExchange(amount, denominations);

        // Print the result
        for (Tuple<Double, Integer> tuple : change) {
            System.out.println(tuple.x + " dollar coin: " + tuple.y);
        }
    }

    public static List<Tuple<Double, Integer>> coinExchange(double amount, List<Double> denominations) {
        List<Tuple<Double, Integer>> result = new ArrayList<>();

        // Sort denominations in descending order
        List<Double> sortedDenominations = new ArrayList<>(denominations);
        Collections.sort(sortedDenominations, Collections.reverseOrder());

        for (double coin : sortedDenominations) {
            if (amount >= coin) {
                int count = (int) (amount / coin);
                amount -= count * coin;
                result.add(new Tuple<>(coin, count));
            }
        }

        return result;
    }

    static class Tuple<X, Y> {
        public final X x;
        public final Y y;

        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
