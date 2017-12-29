package com.eichinn.generics.example;

public class GenericMethods {
    public <T> void f(T t) {
        System.out.println(t.getClass().getSimpleName());
    }

    public <T, U, V> void f(T t, U u, V v) {
        System.out.println(t.getClass().getSimpleName());
        System.out.println(u.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());

    }

    public <U, V> void f(String t, U u, V v) {
        System.out.println(u.getClass().getSimpleName());
        System.out.println(v.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("");
        gm.f(1);
        gm.f(1.0);
        gm.f(1.0F);
        gm.f('c');
        gm.f(gm);
    }
}
