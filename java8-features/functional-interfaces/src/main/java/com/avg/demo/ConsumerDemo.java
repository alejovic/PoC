package com.avg.demo;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {
        // Performs an action on T
        Consumer<String> printMessage = message -> System.out.println("Hello, " + message);

        printMessage.accept("World"); // Output: Hello, World
    }
}
