package com.eichinn.holding.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by ei_chinn on 2017/3/6.
 */
public class Ex12 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list2 = new ArrayList<>();
        ListIterator<Integer> it = list1.listIterator(list1.size());
        while (it.hasPrevious()) {
            list2.add(it.previous());
        }
        System.out.println(list1);
        System.out.println(list2);
    }
}
