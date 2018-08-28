package com.eichinn.containers.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Creating a good hashCode()
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;

    public CountedString(String str) {
        s = str;
        created.add(s);
        // id is the total number of instances of this string in use by CountedString
        for (String s1 : created) {
            if (s1.equals(s)) {
                id++;
            }
        }

    }

    @Override
    public String toString() {
        return "String: " + s + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        // The very simple approach return s.hashCode * id
        // Using Joshua Bloch's recipe:
        int result = 17;
        result = result * 37 + s.hashCode();
        result = result * 37 + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof CountedString)
                && (this.s.equals(((CountedString) obj).s))
                && (this.id == ((CountedString) obj).id);
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi");
            map.put(cs[i], i);
        }

        System.out.println(map);
        for (CountedString c : cs) {
            System.out.println("Looking up: " + c);
            System.out.println(map.get(c));
        }
    }
}
