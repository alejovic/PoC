package com.avg.demo;

import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        // Supplies a value of T
        Supplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get()); // Example: 0.54365243
    }
}
