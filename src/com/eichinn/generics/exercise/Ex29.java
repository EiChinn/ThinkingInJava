package com.eichinn.generics.exercise;

import com.eichinn.generics.example.Holder;

import java.util.ArrayList;
import java.util.List;

public class Ex29 {
    static void test1(Holder<List<?>> holder) {
        holder.set(new ArrayList<Integer>());
        List list = holder.get();
        List<?> list2 = holder.get();
        list.set(0, 1);
        //list2.set(0, 1);
        Object result = list.get(0);
        Object result2 = list2.get(0);
    }

    static void test2(List<Holder<?>> list) {
        list.set(0, new Holder());
        Holder<?> holder = list.get(0);
        Holder holder2 = list.get(0);

        //holder.set(1);
        holder2.set(1);
        Object integer = holder.get();
        Object integer2 = holder2.get();

        Holder<?> wildcard = new Holder<Integer>();
//        wildcard.set(1);
        Object one = wildcard.get();
    }

    static void test3(Holder<?> holder) {
        //holder.set(1);
    }
}
