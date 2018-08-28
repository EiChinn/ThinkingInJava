package com.eichinn.containers.examples;

import com.eichinn.common.Generator;

import java.util.ArrayList;

/**
 *  A Collection filled with data using a generator object
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    /**
     * A generic convenience method:
     * @param gen
     * @param quantity
     * @param <T>
     * @return
     */
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}
