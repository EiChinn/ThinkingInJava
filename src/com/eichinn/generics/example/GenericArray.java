package com.eichinn.generics.example;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    //Method that exposes the underlying representation
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        //This cases a ClassCastException
        //!Integer[] i = gai.rep();
        //This is OK!
        gai.put(0, 1);
        Object[] o = gai.rep();
        int one = (int) o[0];
        System.out.println(one);
    }
}
