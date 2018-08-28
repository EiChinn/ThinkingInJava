package com.eichinn.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *  It's possible to create arrays of generics.
 *
 */
public class ArrayOfGenerics {
    public static void main(String[] args) {
        // 编译器却是不让实例化泛型数组，但允许创建对泛型数组的引用
        List<String>[] ls;

        // 尽管不能创建实际的持有泛型的数组对象，但可以创建非泛型的数组，然后将其转型
        List[] la = new List[10];
        ls = (List<String>[])la;
        ls[0] = new ArrayList<String>();
        // Compile-time checking produces an error
        //! ls[1] = new ArrayList<Integer>();

        Object[] objects = ls; // The problem: List<String>[] is a subtype of Object[], so assignment is OK
        objects[1] = new ArrayList<Integer>(); // Compiles and runs without complaint, but we now its illegal

        // However, if your needs is straightforward it is possible to create an array of generics, albeit with an "unchecked" warning:
        // 但事实上，泛型容器总是比泛型数组更好的选择
        List<String>[] strings = (List<String>[])new List[10];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new ArrayList<>();
        }
    }
}
