package com.avg.demo;

import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    public static void main(String[] args) {
        // Special case of Function<T, T>
        UnaryOperator<Integer> doubler = x -> x * 2;

        System.out.println(doubler.apply(4)); // 8
    }
}
