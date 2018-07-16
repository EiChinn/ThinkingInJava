package com.eichinn.generics.example;

import java.util.ArrayList;
import java.util.List;

public class GenericReading {
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static List<Apple> apples = new ArrayList<>();
    static List<Fruit> fruit = new ArrayList<>();

    //A static method adapts to each call
    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    //If, however, you have a class, then its type is established when the class is instantiated.
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        Reader<Fruit> fruitReader = new Reader<>();
        Fruit f = fruitReader.readExact(fruit);
        //!Fruit a = fruitReader.readExact(apples);//readExact(List<Fruit>) cannot be applied to (List<Apple>)

    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> fruitCovariantReader = new CovariantReader<>();
        Fruit f = fruitCovariantReader.readCovariant(fruit);
        Fruit a = fruitCovariantReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        apples.add(new Apple());
        fruit.add(new Apple());
        f1();
        f2();
        f3();
    }
}
