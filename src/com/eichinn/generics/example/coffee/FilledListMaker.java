package com.eichinn.generics.example.coffee;

import java.util.ArrayList;
import java.util.List;

public class FilledListMaker<T> {
    public List<T> create(T t, int size) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(t);

        }
        return result;
    }

    public static void main(String[] args) {
        FilledListMaker<Integer> integerFilledList = new FilledListMaker<>();
        List<Integer> intList = integerFilledList.create(8, 8);
        System.out.println(intList);
    }
}
