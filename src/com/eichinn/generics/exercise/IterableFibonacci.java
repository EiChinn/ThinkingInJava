package com.eichinn.generics.exercise;

import com.eichinn.generics.example.Fibonacci;

import java.util.Iterator;

/**
 * Adapt the Fibonacci class to make it iterable
 */
public class IterableFibonacci implements Iterable<Integer> {
    private int n;
    private Fibonacci fibonacci;

    public IterableFibonacci(int n) {
        this.n = n;
        fibonacci = new Fibonacci();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return fibonacci.next();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFibonacci(18)) {
            System.out.println(i);
        }
    }
}
