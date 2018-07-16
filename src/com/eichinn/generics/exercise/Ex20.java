package com.eichinn.generics.exercise;

public class Ex20 {
    public static <T extends IEx20> void f(T t) {
        t.f1();
        t.f2();
    }

    public static void main(String[] args) {
        f(new CEx20());
    }
}

interface IEx20 {
    void f1();
    void f2();
}

class CEx20 implements IEx20{

    @Override
    public void f1() {

    }

    @Override
    public void f2() {

    }

    public void f3() {

    }
}
