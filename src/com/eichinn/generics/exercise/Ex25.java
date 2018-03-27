package com.eichinn.generics.exercise;

public class Ex25 {
    private <E extends IEx25One> void m1(E e) {

    }
    private <E extends IEx25Two> void m2(E e) {

    }

    public static void main(String[] args) {
        Ex25 ex25 = new Ex25();
        ex25.m1(new CEx25One());
        ex25.m2(new CEx25One());
    }

}

interface IEx25One {

}

interface IEx25Two {

}

class CEx25One implements IEx25One, IEx25Two {

}
