package com.eichinn.common;

import com.eichinn.containers.examples.CollectionData;

import java.lang.reflect.Array;

public class Generated {

    /**
     * Fill an exiting array
     * @param a
     * @param generator
     * @param <T>
     * @return
     */
    public static <T> T[] array(T[] a, Generator<T> generator) {
        return new CollectionData<T>(generator, a.length).toArray(a);
    }

    /**
     * Create a new array
     * @param type
     * @param generator
     * @param size
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] array(Class<T> type, Generator<T> generator, int size) {
        T[] a = (T[]) Array.newInstance(type, size);
        return new CollectionData<>(generator, size).toArray(a);
    }
}
