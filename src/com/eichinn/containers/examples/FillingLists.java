package com.eichinn.containers.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Collections.fill() & Collections.nCopies() methods
 */
public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!")); // fill方法只能替换已存在list中的元素，而不能添加新的元素，因为list是不定长的
        System.out.println(list);
    }
}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
