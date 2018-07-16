package com.eichinn.generics.example;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> fruit = Arrays.asList(new Apple());
        Apple apple = (Apple) fruit.get(0);
        fruit.contains(new Apple());//argument is 'Object'
        fruit.indexOf(new Apple());//argument is 'Object'
    }
}
