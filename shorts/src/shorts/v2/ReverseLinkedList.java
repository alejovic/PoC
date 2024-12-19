package shorts.v2;

import java.util.LinkedList;

/**
 * 13. How do you reverse a linked list in Java?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);
        ll.add(2);
        ll.add(3);

        System.out.println(ll);

        LinkedList<Integer> ll1 = new LinkedList<>();
        // descendingIterator() returns an iterator that iterates over the element in reverse order
        ll.descendingIterator().forEachRemaining(ll1::add);

        System.out.println(ll1);
    }
}
