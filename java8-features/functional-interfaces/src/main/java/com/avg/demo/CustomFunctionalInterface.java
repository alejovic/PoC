package com.avg.demo;

@FunctionalInterface
public interface CustomFunctionalInterface {
    void doSomething();

//    BrokenInterface
//    void breakSomethingElse();

    default void doSomethingDefautl() {
        System.out.print("CustomFunctionalInterface doSomethingDefautl");
    }

    static void doSomethingStatic() {
        System.out.print("CustomFunctionalInterface doSomethingStatic");
    }
}
