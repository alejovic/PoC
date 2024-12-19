package shorts.v2;

interface I {
    void doSomething();
}

class A implements I {
    @Override
    public void doSomething() {

    }
}

class B implements I {
    @Override
    public void doSomething() {

    }
}

// class C extends A,B { -> no compile
//
//}

public class DiamondProblem {


}
