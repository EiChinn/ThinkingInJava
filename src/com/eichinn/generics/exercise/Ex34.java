package com.eichinn.generics.exercise;

public class Ex34 {
    public static void main(String[] args) {
        Ex34Derived2 derived2 = new Ex34Derived2();
        derived2.test(derived2);
        Ex34Derived1 derived1 = new Ex34Derived1();
        derived1.test(derived1);
    }
}

abstract class Ex34Base<T extends Ex34Base<T>> {
    abstract T getAndSet(T t);

    public T test(T t) {
        return getAndSet(t);

    }
}

class Ex34Derived1 extends Ex34Base<Ex34Derived1> {

    @Override
    Ex34Derived1 getAndSet(Ex34Derived1 ex34Derived1) {
        System.out.println(ex34Derived1.getClass().getSimpleName());
        return ex34Derived1;
    }
}
class Ex34Derived2 extends Ex34Base<Ex34Derived2> {

    @Override
    Ex34Derived2 getAndSet(Ex34Derived2 ex34Derived2) {
        System.out.println(ex34Derived2.getClass().getSimpleName());
        return ex34Derived2;
    }
}
