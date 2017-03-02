package com.eichinn.holding;

import java.util.*;

/**
 * Created by ei_chinn on 2017/3/2.
 */
public class ListFeatures {
    public static void main(String[] args) {
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
