package com.eichinn.generics.example;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    List<T> create(T t, int n) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<String> stringMaker = new FilledListMaker<>();
        List<String> stringList = stringMaker.create("Hello", 4);
        System.out.println(stringList);
    }
}
