package com.eichinn.generics.example.coffee;

import java.util.ArrayList;
import java.util.List;

public class ListMaker<T> {
    public List<T> create() {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        ListMaker<Integer> intListMaker = new ListMaker<>();
        List<Integer> intList = intListMaker.create();
    }
}
