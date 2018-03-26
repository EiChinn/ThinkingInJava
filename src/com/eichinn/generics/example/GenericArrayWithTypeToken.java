package com.eichinn.generics.example;

import java.lang.reflect.Array;

public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    //Expose the underlying representation
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = new GenericArrayWithTypeToken<>(Integer.class, 10);
        //This now works
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + "");
        }

        Integer[] a = gai.rep();
        for (Integer integer : a) {
            System.out.print(integer + " ");
        }


    }
}
