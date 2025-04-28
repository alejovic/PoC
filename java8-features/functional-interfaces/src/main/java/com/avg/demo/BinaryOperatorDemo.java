package com.avg.demo;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {

    public static void main(String[] args) {
        // Combines two Ts into one
        BinaryOperator<Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(5, 7)); // 12
    }
}
