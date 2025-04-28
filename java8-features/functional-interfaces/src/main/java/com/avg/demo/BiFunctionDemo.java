package com.avg.demo;

import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {
        // Takes two inputs, returns R
        BiFunction<String, String, String> concat = (a, b) -> a + b;

        System.out.println(concat.apply("Hello ", "World")); // "Hello World"
    }
}
