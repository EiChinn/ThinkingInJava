package com.eichinn.generics.example;

import com.eichinn.common.CountedInteger;
import com.eichinn.common.Generator;

/**
 * Automatically create a generator, given a class with a default(non-arg) constructor
 */
public class BasicGenerator<T> implements Generator<T> {
    private Class<T> type;

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    @Override
    public T next() {
        try {
            //Assumes type is a public class
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * produce a default generator given a type token
     * @param type
     * @param <T>
     * @return
     */
    public static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        Generator<CountedInteger> generator = BasicGenerator.create(CountedInteger.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.next());
        }
    }
}
