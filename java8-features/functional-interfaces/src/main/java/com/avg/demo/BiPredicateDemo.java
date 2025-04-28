package com.avg.demo;

import java.util.function.BiPredicate;

public class BiPredicateDemo {

    public static void main(String[] args) {
        // Tests two inputs
        BiPredicate<String, String> equalsIgnoreCase = (a, b) -> a.equalsIgnoreCase(b);

        System.out.println(equalsIgnoreCase.test("java", "JAVA")); // true
    }
}
