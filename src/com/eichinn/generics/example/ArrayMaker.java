package com.eichinn.generics.example;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMaker<K> {
    private Class<K> kind;

    public ArrayMaker(Class<K> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    public K[] create(int size) {
        //对于在泛型中创建数组，Array.newInstance();是推荐的做法
        return (K[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<Integer> arrayMaker = new ArrayMaker<>(Integer.class);
        Integer[] arrayString = arrayMaker.create(9);
        System.out.println(Arrays.toString(arrayString));
    }
}
