package com.eichinn.holding.example;

import java.util.*;

/**
 * Created by ei_chinn on 2017/3/2.
 */
public class ListFeatures {
    public static void main(String[] args) {
//        testObject();
//        testInteger();
        testString();
























    }

    private static void testString() {
        Random random = new Random(47);
        List<String> pets = new ArrayList<>();
        Collections.addAll(pets, "otamegane", "ei_chinn", "shana", "yui", "mio", "ritsu", "tsumuki");
        System.out.println("1: " + pets);

        pets.add("mikoto");//Automatically resize
        System.out.println("2: " + pets);
        pets.add("mikoto");//Automatically resize
        System.out.println("pets: " + pets);
//
        System.out.println("3: " + pets.contains("mikoto"));
        pets.remove("mikoto");//remove 第一个使用equals为true的元素，然后马上返回
        System.out.println("pets: " + pets);

        String p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
////
        String cymric = "shana";//因为Integer的equals方法
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.contains(cymric));
////
////        //must be the exact object
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
////
        pets.add(3, "shana");//insert at an index
        System.out.println("9: " + pets);
////
        List<String> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);

        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("pets: " + pets);
////        //order is not important in containsAll();
        System.out.println("11: " + pets.containsAll(sub));
//        Collections.shuffle(sub, random);
        System.out.println("shuffle subList: " + sub);
        System.out.println("pets: " + pets);
        System.out.println("12: " + pets.containsAll(sub));
////
        List<String> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
////
        copy.retainAll(sub);//copy 只保留与sub的交集
        System.out.println("13: " + copy);
////
        copy = new ArrayList<>(pets);
        copy.remove(3);//remove by index
        System.out.println("14: " + copy);

        sub.set(1, "ui");
        System.out.println("sub: " + sub);
        copy.removeAll(sub);//only removes exact objects
        System.out.println("15: " + copy);
////
        copy.set(0, "sawako");//replace an element
        System.out.println("16: " + copy);

        System.out.println("sub: " + sub);
        copy.addAll(2, sub);//insert a list in the middle
        System.out.println("17: " + copy);
////
        System.out.println("18: " + pets.isEmpty());
////
        pets.clear();//remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
////
        pets.addAll(Arrays.asList("kagami", "tsukasa", "minani", "haruka", "kana", "tsuaki"));
        System.out.println("21: " + pets);
////
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
////
        String[] pa = pets.toArray(new String[0]);
        System.out.println("23: " + o[3]);
////
        sub = pets.subList(1, 4);
        System.out.println("24: " + pets);

        pets.addAll(3, sub);
        pets.addAll(pets);
        System.out.println("25: " + pets);
    }
    private static void testInteger() {
        Random random = new Random(47);
        List<Integer> pets = new ArrayList<>();
        Collections.addAll(pets, 1, 2, 3, 4, 5, 6, 7);
        System.out.println("1: " + pets);

        pets.add(8);//Automatically resize
        System.out.println("2: " + pets);
        pets.add(8);//Automatically resize
        System.out.println("pets: " + pets);

        System.out.println("3: " + pets.contains(8));
        pets.remove(Integer.valueOf(8));//remove 第一个使用equals为true的元素，然后马上返回
        System.out.println("pets: " + pets);
        Integer p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
//
        Integer cymric = new Integer(8);//因为Integer的equals方法
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.contains(cymric));
//
//        //must be the exact object
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
//
        pets.add(3, 7);//insert at an index
        System.out.println("9: " + pets);
//
        List<Integer> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("pets: " + pets);
//        //order is not important in containsAll();
        System.out.println("11: " + pets.containsAll(sub));
//        Collections.shuffle(sub, random);
        System.out.println("shuffle subList: " + sub);
        System.out.println("pets: " + pets);
        System.out.println("12: " + pets.containsAll(sub));
//
        List<Integer> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
//
        copy.retainAll(sub);//copy 只保留与sub的交集
        System.out.println("13: " + copy);
//
        copy = new ArrayList<>(pets);
        copy.remove(3);//remove by index
        System.out.println("14: " + copy);
        sub.set(1, 15);
        System.out.println("sub: " + sub);
        copy.removeAll(sub);//only removes exact objects
        System.out.println("15: " + copy);
//
        copy.set(0, 0);//replace an element
        System.out.println("16: " + copy);
        System.out.println("sub: " + sub);
        copy.addAll(2, sub);//insert a list in the middle
        System.out.println("17: " + copy);
//
        System.out.println("18: " + pets.isEmpty());
//
        pets.clear();//remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
//
        pets.addAll(Arrays.asList(1, 4, 7, 8, 9));
        System.out.println("21: " + pets);
//
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
//
        Integer[] pa = pets.toArray(new Integer[0]);
        System.out.println("23: " + o[3]);
//
        sub = pets.subList(1, 4);
        System.out.println("24: " + pets);
        pets.addAll(3, sub);
        pets.addAll(pets);
        System.out.println("25: " + pets);
    }
    private static void testObject() {
        Random random = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        System.out.println("1: " + pets);

        Hamster hamster = new Hamster();
        pets.add(hamster);//Automatically resize
        System.out.println("2: " + pets);

        System.out.println("3: " + pets.contains(hamster));
        pets.remove(hamster);//remove by object
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));

        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.contains(cymric));

        //must be the exact object
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);

        pets.add(3, new Mouse());//insert at an index
        System.out.println("9: " + pets);

        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        System.out.println("pets: " + pets);
        //order is not important in containsAll();
        System.out.println("11: " + pets.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("shuffle subList: " + sub);
        System.out.println("pets: " + pets);
        System.out.println("12: " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);

        copy.retainAll(sub);//copy 只保留与sub的交集
        System.out.println("13: " + copy);

        copy = new ArrayList<>(pets);
        copy.remove(3);//remove by index
        System.out.println("14: " + copy);
        sub.set(1, new Rat());
        copy.removeAll(sub);//only removes exact objects
        System.out.println("15: " + copy);

        copy.set(0, new Mouse());//replace an element
        System.out.println("16: " + copy);
        System.out.println("sub: " + sub);
        copy.addAll(2, sub);//insert a list in the middle
        System.out.println("17: " + copy);

        System.out.println("18: " + pets.isEmpty());

        pets.clear();//remove all elements
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());

        pets.addAll(Pets.arrayList(4));
        System.out.println("21: " + pets);

        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);

        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + o[3]);

        sub = pets.subList(1, 4);
        System.out.println("24: " + pets);
        pets.addAll(3, sub);
        pets.addAll(pets);
        System.out.println("25: " + pets);
    }
}
