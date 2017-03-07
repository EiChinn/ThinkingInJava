package com.eichinn.holding.example;

import java.util.*;

/**
 * Created by ei_chinn on 2017/3/7.
 */
public class SortedSetOperation {
    public static void main(String[] args) {
        Random random = new Random(47);
        SortedSet<Integer> intset = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            intset.add(random.nextInt(30));
        }
        System.out.println(intset);


        String str = "I am the bone of my sword Steel is my body&Fire is my blood I have created over a thousand blades " +
                "Unknown to Death,Nor known to Life " +
                "Have with stood pain to create many weapons " +
                "Yet,those hands will never hold anything " +
                "So as I pray,Unlimited Blade Works";
        SortedSet<String> srtSet = new TreeSet<>(Arrays.asList(str.split(" ")));
        System.out.println(srtSet);

        SortedSet<String> srtSet1 = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        Collections.addAll(srtSet1, str.split(" "));
        System.out.println(srtSet1);
    }
}
