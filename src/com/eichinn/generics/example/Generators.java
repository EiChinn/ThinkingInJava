package com.eichinn.generics.example;

import com.eichinn.common.Generator;
import com.eichinn.generics.example.coffee.Coffee;
import com.eichinn.generics.example.coffee.CoffeeGenerator;

import java.util.*;

public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        System.out.println("fill Collection");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
        System.out.println("fill List");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static <T> LinkedList<T> fill(LinkedList<T> coll, Generator<T> gen, int n) {
        System.out.println("fill LinkedList");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static <T> Set<T> fill(Set<T> coll, Generator<T> gen, int n) {
        System.out.println("fill Set");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }
    public static <T> Queue<T> fill(Queue<T> coll, Generator<T> gen, int n) {
        System.out.println("fill Queue");
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> coffees = fill(new ArrayList<>(), new CoffeeGenerator(), 4);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        Collection<Integer> fnumbers = fill(new ArrayList<>(), new Fibonacci(), 12);
        for (Integer fnumber : fnumbers) {
            System.out.print(fnumber + ", ");
        }
    }
}
