package com.avg.demo;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {
        // Transforms T into R
        Function<Integer, String> toStringFunction = num -> "Number: " + num;
        System.out.println(toStringFunction.apply(10)); // "Number: 10"
    }
}
