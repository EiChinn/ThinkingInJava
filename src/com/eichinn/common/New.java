package com.eichinn.common;

import com.eichinn.typeinfo.example.nullobject.Person;
import com.eichinn.typeinfo.example.pets.Pet;

import java.util.*;

/**
 * Utilities to simplify generic container creation by using type argument inference
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> LinkedList<T> lLIst() {
        return new LinkedList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    static void f(Map<Person, List<? extends Pet>> petPeople) {

    }

    public static void main(String[] args) {
        Map<String, List<String>> sls = New.map();
        List<String> list = New.list();
        LinkedList<String> lList = New.lLIst();
        Queue<String> qs = New.queue();
        f(New.map());
        f(New.<Person, List<? extends Pet>>map());
    }
}
