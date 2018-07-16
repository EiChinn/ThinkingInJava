package com.eichinn.generics.example;

public class BasicHolder<T> {
    T element;
    T get() {
        return element;
    }

    void set(T element) {
        this.element = element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}
