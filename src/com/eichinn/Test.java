package com.eichinn;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final String PREFIX = "Time is ";
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        List<String> list2 = new ArrayList<>();
        for (String s : list) {
//            System.out.println(System.currentTimeMillis() + list2.size());
            list2.add("" + System.currentTimeMillis() + list2.size());
        }

        for (String s : list2) {
            System.out.println(s);
        }

    }
}
