package com.avg.demo;

public class CustomDemo {

    public static void main(String[] args) {
        CustomFunctionalInterface obj = () -> System.out.println("Doing work");
        obj.doSomething();
    }
}
