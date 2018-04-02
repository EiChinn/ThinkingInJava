package com.eichinn.generics.example;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> fruits = Arrays.asList(new Apple());
        Apple apple = (Apple) fruits.get(0);
        fruits.contains(new Apple());//argument is 'Object'
        fruits.indexOf(new Apple());//argument is 'Object'
    }
}
