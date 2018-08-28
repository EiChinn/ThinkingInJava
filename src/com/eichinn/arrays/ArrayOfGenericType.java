package com.eichinn.arrays;

/**
 *  Arrays of generic types won't compile
 * @param <T>
 */
public class ArrayOfGenericType<T> {
    T[] array; // OK

    public ArrayOfGenericType(int size) {
        //! array = new T[size]; // Illegal
        array = (T[]) new Object[size];
    }

    //! public <U> U[] makeArray() { return new U[10]; } // Illegal
}
