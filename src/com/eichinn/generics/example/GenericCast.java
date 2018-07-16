package com.eichinn.generics.example;

import java.util.ArrayList;

public class GenericCast {
    private static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings = new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" ")) {
            strings.push(s);
        }
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
    }
}

class FixedSizeStack<T> {
    private int index = 0;
    private ArrayList<Object> storage;

    public FixedSizeStack(int size) {
        storage = new ArrayList<>(size);
    }

    public void push(T t) {
        storage.add(index++, t);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return (T) storage.get(--index);
    }
}
