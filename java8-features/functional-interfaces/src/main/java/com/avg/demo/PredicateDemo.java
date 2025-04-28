package com.avg.demo;

import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        // Tests a condition, returns boolean
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.printf("PredicateDemo: %s\n", predicate.test("hello"));
        System.out.printf("PredicateDemo: %s\n", predicate.test("hello world!"));
    }
}
